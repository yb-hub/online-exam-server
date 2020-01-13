package com.yb.onlineexamserver.service.teacher.impl;

import com.yb.onlineexamserver.common.enums.statusenums.QuestionEnums;
import com.yb.onlineexamserver.dao.PaperDao;
import com.yb.onlineexamserver.dao.QuestionDao;
import com.yb.onlineexamserver.dto.PaperDto;
import com.yb.onlineexamserver.mbg.model.Paper;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.requestparams.PaperParams;
import com.yb.onlineexamserver.service.teacher.PaperService;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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

    @Override
    public int insertPaper(PaperParams paperParams) {
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
        papers = (ArrayList<PaperDto>) papers.stream().map(paper->{
            paper.setDifficultyDegree();
            return paper;
        }).collect(Collectors.toList());
        //选出最适合的一套试卷
        PaperDto fitnessPaper = getFitness(papers,paperParams.getDifficultyDegree());
        System.out.println("随机生成的最适合的试卷(难度)："+ fitnessPaper.getDifficultyDegree());
        //开始进化，每次保留最适合的试卷
        for (int i = 0; i < 5; i++) {
            ArrayList<PaperDto> newPaperList = new ArrayList<>();
            newPaperList.add(fitnessPaper);
            while(newPaperList.size() < paperListSize){
                //选取两个父试卷
                PaperDto parent1 = selectParentPaper(papers);
                PaperDto parent2 = selectParentPaper(papers);
                while(parent1 == parent2){
                    parent2 = selectParentPaper(papers);
                }
                //开始交叉繁殖
                Integer totalQuestion = parent1.getTotalQuestion();
                int randowNumber1 = new Random().nextInt(totalQuestion);
                int randowNumber2 = new Random().nextInt(totalQuestion);
                if(randowNumber1 > randowNumber2){
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
            fitnessPaper = getFitness(newPaperList, paperParams.getDifficultyDegree());
            System.out.println("进化次数："+i+"难度："+ fitnessPaper.getDifficultyDegree());
        }
        return 1;
    }

    private PaperDto selectParentPaper(ArrayList<PaperDto> papers) {
        Random random = new Random();
        int randowNumber = random.nextInt(papers.size());
        return papers.get(randowNumber);
    }

    private PaperDto getFitness(ArrayList<PaperDto> papers,Long difficultyDegree) {
        if(papers.size() >= 1){
            PaperDto fitnessPaper = papers.get(0);
            Long degreeDifference = Math.abs(difficultyDegree-fitnessPaper.getDifficultyDegree());
            for (PaperDto paper : papers) {
                //System.out.println(paper.toString());
                //System.out.println(paper.getDifficultyDegree());
                if(Math.abs(paper.getDifficultyDegree()-difficultyDegree) < degreeDifference){
                    fitnessPaper = paper;
                    degreeDifference =Math.abs(paper.getDifficultyDegree()-difficultyDegree);
                }
            }
            return fitnessPaper;
        }else{
            return new PaperDto();
        }
    }
}
