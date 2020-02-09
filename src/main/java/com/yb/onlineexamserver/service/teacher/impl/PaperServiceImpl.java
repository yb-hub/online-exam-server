package com.yb.onlineexamserver.service.teacher.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yb.onlineexamserver.common.enums.statusenums.QuestionEnums;
import com.yb.onlineexamserver.dao.PaperDao;
import com.yb.onlineexamserver.dao.PaperQuestionDao;
import com.yb.onlineexamserver.dao.QuestionDao;
import com.yb.onlineexamserver.dto.PaperDetailDto;
import com.yb.onlineexamserver.dto.PaperDto;
import com.yb.onlineexamserver.dto.QuestionOption;
import com.yb.onlineexamserver.mbg.mapper.PaperMapper;
import com.yb.onlineexamserver.mbg.model.Paper;
import com.yb.onlineexamserver.mbg.model.PaperExample;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.requestparams.PaperParams;
import com.yb.onlineexamserver.service.teacher.PaperService;
import com.yb.onlineexamserver.utils.PaperLimitTimeUtils;
import com.yb.onlineexamserver.vo.PaperDetailVo;
import com.yb.onlineexamserver.vo.PaperVo;
import com.yb.onlineexamserver.vo.QuestionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: Yang
 * @Date: 2020/01/10 14:11
 * @Description:
 */
@Service
public class PaperServiceImpl implements PaperService {
    /***
     * 种群数量
     */
    private static final int paperListSize = 20;
    /***
     * 变异概率
     */
    private static final double mutationRate = 0.085;
    /**
     * 精英主义
     */
    private static final boolean elitism = true;
    /**
     * 淘汰数组大小
     */
    private static final int tournamentSize = 5;

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private PaperQuestionDao paperQuestionDao;
    @Autowired
    private PaperMapper paperMapper;

    @Override
    @Transactional
    public int insertPaper(PaperParams paperParams) {
        PaperDto fitnessPaper = new PaperDto();
        //BeanUtil.copyProperties(paperParams,fitnessPaper);
        //创建一个种群
        ArrayList<PaperDto> papers = new ArrayList<>();
        for (int i = 0; i < paperListSize; i++) {
            PaperDto paper = new PaperDto();
            //获取单选题，多选题，判断题数量
            Integer totalSingleChoice = paperParams.getTotalSingleChoice();
            Integer totalMultiChoice = paperParams.getTotalMultiChoice();
            Integer totalJudgeChoice = paperParams.getTotalJudgeChoice();
            List<Question> singleList = questionDao.queryLimitQuestionByType(QuestionEnums.SIMPLE_QUESTION.getCode(), totalSingleChoice);
            List<Question> multiList = questionDao.queryLimitQuestionByType(QuestionEnums.MULTI_QUESTION.getCode(), totalMultiChoice);
            List<Question> judgeList = questionDao.queryLimitQuestionByType(QuestionEnums.JUDGE_QUESTION.getCode(), totalJudgeChoice);
            paper.setSingleChoiceList(singleList);
            paper.setMultiChoiceList(multiList);
            paper.setJudgeChoiceList(judgeList);
            paper.setTotalQuestion(paperParams.getTotalQuestion());
            ArrayList<Question> questions = new ArrayList<>();
            for (Question question : singleList) {
                questions.add(question);
            }
            for (Question question : multiList) {
                questions.add(question);
            }
            for (Question question : judgeList) {
                questions.add(question);
            }
            paper.setQuestionList(questions);
            papers.add(paper);
        }
        papers = (ArrayList<PaperDto>) papers.stream().map(paper -> {
            paper.setDifficultyDegree();
            return paper;
        }).collect(Collectors.toList());
        //选出最适合的一套试卷
        fitnessPaper = getFitness(papers, paperParams.getDifficultyDegree());
        System.out.println("随机生成的最适合的试卷(难度)：" + fitnessPaper.getDifficultyDegree());
        //开始进化，每次保留最适合的试卷
        for (int i = 0; i < 5; i++) {
            ArrayList<PaperDto> newPaperList = new ArrayList<>();
            newPaperList.add(fitnessPaper);
            while (newPaperList.size() < paperListSize) {
                //选取两个父试卷
                PaperDto parent1 = selectParentPaper(papers);
                PaperDto parent2 = selectParentPaper(papers);
                while (parent1 == parent2) {
                    parent2 = selectParentPaper(papers);
                }
                //开始交叉繁殖
                Integer totalQuestion = parent1.getTotalQuestion();
                int randowNumber1 = new Random().nextInt(totalQuestion);
                int randowNumber2 = new Random().nextInt(totalQuestion);
                if (randowNumber1 > randowNumber2) {
                    int tempNumber = randowNumber1;
                    randowNumber1 = randowNumber2;
                    randowNumber2 = tempNumber;
                }
//                System.out.println("random1:"+randowNumber1);
//                System.out.println("random2:"+randowNumber2);
                PaperDto newPaper = new PaperDto();
                newPaper.setQuestionList(new ArrayList<Question>());
                //从父试卷1中选择randowNumber1和randowNumber2中的试题
                for (int j = 0; j < randowNumber1; j++) {
                    newPaper.getQuestionList().add(parent2.getQuestionList().get(j));
                }
                for (int j = randowNumber1; j < randowNumber2; j++) {
                    newPaper.getQuestionList().add(parent1.getQuestionList().get(j));
                }
                for (int j = randowNumber2; j < parent2.getQuestionList().size(); j++) {
                    newPaper.getQuestionList().add(parent2.getQuestionList().get(j));
                }

                //开始变异
                for (Question question : newPaper.getQuestionList())
                    if (new Random().nextFloat() < mutationRate) {
                        //这里开始变异了
                        Integer type = question.getType();
                        //从数据库中获取和此题相同类型的题目
                        List<Question> questions = questionDao.queryLimitQuestionByType(type, 1);
                        List<Question> nullQuestions = new ArrayList<>();
                        nullQuestions.add(question);
                        question = Optional.ofNullable(questions).orElse(nullQuestions).get(0);
                    }
                newPaper.setDifficultyDegree();
                newPaperList.add(newPaper);
            }
//            for (PaperDto paperDto : newPaperList) {
//                System.out.println("==============");
//                System.out.println("试卷难度："+paperDto.getDifficultyDegree());
//                for (Question question : paperDto.getQuestionList()) {
//                    System.out.println(question.getTitle());
//                }
//            }
            fitnessPaper = getFitness(newPaperList, paperParams.getDifficultyDegree());
            for (Question question : fitnessPaper.getQuestionList()) {
                System.out.println("标题：" + question.getTitle());
                System.out.println("类型：" + question.getType());
            }
            System.out.println("进化次数：" + i + "难度：" + fitnessPaper.getDifficultyDegree());
        }
        //将试卷存入数据库中
        Paper paper = new Paper();
        //BeanUtil.copyProperties(paperParams,paper);
        // BeanUtils.copyProperties(paperParams, fitnessPaper);
        BeanUtils.copyProperties(paperParams, paper);
        paper.setLimitTime(PaperLimitTimeUtils.TimeToMinute(paperParams.getLimitTime()));
        paper.setCreateTime(LocalDateTime.now());
        paper.setUpdateTime(LocalDateTime.now());
        paperMapper.insertSelective(paper);
        //将生成试题和试卷关系表
        Integer paperId = paper.getId();
        List<String> questionIdList = fitnessPaper.getQuestionList().stream()
                .map(question -> question.getId()).collect(Collectors.toList());
        return paperQuestionDao.insertPaperQuestions(paperId, questionIdList);
    }

    private PaperDto selectParentPaper(ArrayList<PaperDto> papers) {
        Random random = new Random();
        int randowNumber = random.nextInt(papers.size());
        return papers.get(randowNumber);
    }

    private PaperDto getFitness(ArrayList<PaperDto> papers, Double difficultyDegree) {
        if (papers.size() >= 1) {
            PaperDto fitnessPaper = papers.get(0);
            Double degreeDifference = Math.abs(difficultyDegree - fitnessPaper.getDifficultyDegree());
            for (PaperDto paper : papers) {
                //System.out.println(paper.toString());
                //System.out.println(paper.getDifficultyDegree());
                if (Math.abs(paper.getDifficultyDegree() - difficultyDegree) < degreeDifference) {
                    fitnessPaper = paper;
                    degreeDifference = Math.abs(paper.getDifficultyDegree() - difficultyDegree);
                }
            }
            return fitnessPaper;
        } else {
            return new PaperDto();
        }
    }

    @Override
    public List<PaperVo> queryPaperList(String keyWord, Integer courseId, Integer page, Integer pageSize, String sort) {
        PaperExample example = new PaperExample();
        PaperExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyWord)) {
            criteria.andTitleLike("%" + keyWord + "%");
        }
        if (courseId != null) {
            criteria.andCourseIdEqualTo(courseId);
        }
        if (!StringUtils.isEmpty(sort)) {
            example.setOrderByClause(sort);
        }
        PageHelper.startPage(page, pageSize);
        Page<Paper> paperList = (Page<Paper>) paperMapper.selectByExample(example);
        Page<PaperVo> paperVoList = new Page<PaperVo>();
        BeanUtils.copyProperties(paperList, paperVoList);
        for (Paper paper : paperList) {
            PaperVo paperVo = new PaperVo();
            BeanUtils.copyProperties(paper, paperVo);
            paperVoList.add(paperVo);
        }
        return paperVoList;
    }

    @Override
    public PaperDetailVo queryPaperById(Integer id) {
        PaperDetailDto paperDetailDto = paperDao.queryPaperById(id);
        PaperDetailVo paperDetailVo = new PaperDetailVo();
        BeanUtils.copyProperties(paperDetailDto,paperDetailVo);
        List<Question> totalQuestionList = paperDetailDto.getTotalQuestionList();
        paperDetailVo.setSingleChoiceList(new ArrayList<>());
        paperDetailVo.setMultiChoiceList(new ArrayList<>());
        paperDetailVo.setJudgeChoiceList(new ArrayList<>());
        for (Question question : totalQuestionList) {
            List<QuestionOption> questionOptions = JSON.parseArray(question.getOptions(), QuestionOption.class);
            List<String> rightOptions = JSON.parseArray(question.getRightOption(),String.class);
            QuestionVo questionVo = new QuestionVo();
            BeanUtils.copyProperties(question, questionVo);
            questionVo.setOptions(questionOptions);
            questionVo.setRightOption(rightOptions);
            if(question.getType() == QuestionEnums.SIMPLE_QUESTION.getCode()){
                paperDetailVo.getSingleChoiceList().add(questionVo);
            }
            else if(question.getType() == QuestionEnums.MULTI_QUESTION.getCode()){
                paperDetailVo.getMultiChoiceList().add(questionVo);
            }
            else if(question.getType() == QuestionEnums.JUDGE_QUESTION.getCode()){
                paperDetailVo.getJudgeChoiceList().add(questionVo);
            }
        }
        return paperDetailVo;
    }

    @Override
    @Transactional
    public int deletePaper(Integer id) {
        paperMapper.deleteByPrimaryKey(id);
        //同时删除试卷题目表中的数据
        return paperQuestionDao.deleteByPaperId(id);
    }
}
