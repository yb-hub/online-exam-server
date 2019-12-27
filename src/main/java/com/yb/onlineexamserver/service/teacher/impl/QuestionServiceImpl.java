package com.yb.onlineexamserver.service.teacher.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.yb.onlineexamserver.common.enums.courseenums.CourseEnums;
import com.yb.onlineexamserver.common.enums.questionenums.QuestionEnums;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.dao.QuestionDao;
import com.yb.onlineexamserver.dto.QuestionDto;
import com.yb.onlineexamserver.dto.QuestionOption;
import com.yb.onlineexamserver.mbg.mapper.CourseMapper;
import com.yb.onlineexamserver.mbg.mapper.QuestionMapper;
import com.yb.onlineexamserver.mbg.model.Course;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.mbg.model.QuestionExample;
import com.yb.onlineexamserver.requestparams.QuestionParam;
import com.yb.onlineexamserver.respository.QuestionRepository;
import com.yb.onlineexamserver.service.teacher.QuestionService;
import com.yb.onlineexamserver.utils.KeyUtils;
import com.yb.onlineexamserver.vo.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2019/11/13 21:53
 * @Description:
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public int insertQuestions(QuestionParam questionParam) {
        checkCourse(questionParam.getCourseId());
        Question question = new Question();
        BeanUtil.copyProperties(questionParam, question);
        question.setId(KeyUtils.createUniqueKey());
        question.setCreateTime(LocalDateTime.now());
        question.setUpdateTime(LocalDateTime.now());
        question.setOptions(JSON.toJSONString(questionParam.getOptions()));
        question.setRightOption(JSON.toJSONString(questionParam.getRightOption()));
        return questionMapper.insertSelective(question);
    }

    @Override
    public int insertQuestionsList(List<Question> questionList) {
        return questionDao.insertQuestionsList(questionList);
    }

    @Override
    public int deleteQuestions(String id) {
        queryQuestionsById(id);
        return questionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Question queryQuestionsById(String id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if(question == null){
            throw new  OnlineExamException(QuestionEnums.QUESTION_NOT_FOUND);
        }
        return question;
    }

    @Override
    public int updateQuestions(String id, QuestionParam questionParam) {
        checkCourse(questionParam.getCourseId());
        Question question = queryQuestionsById(id);
        BeanUtil.copyProperties(questionParam, question);
        question.setUpdateTime(LocalDateTime.now());
        question.setOptions(JSON.toJSONString(questionParam.getOptions()));
        question.setRightOption(JSON.toJSONString(questionParam.getRightOption()));
        return questionMapper.updateByPrimaryKeySelective(question);
    }

    @Override
    public List<QuestionVo> queryQuestionsList(String keyWord, Integer courseId, Integer page, Integer pageSize, String sort) {
        PageHelper.startPage(page, pageSize);
        List<QuestionDto> questionDtos = questionDao.queryQuestionsList(keyWord, courseId, page, pageSize, sort);
        ArrayList<QuestionVo> questionVos = new ArrayList<>();
        for (QuestionDto questionDto : questionDtos) {
            String options = questionDto.getOptions();
            List<QuestionOption> questionOptions = JSON.parseArray(options, QuestionOption.class);
            List<String> rightOptions = JSON.parseArray(questionDto.getRightOption(), String.class);
            QuestionVo questionVo = new QuestionVo();
            BeanUtil.copyProperties(questionDto, questionVo);
            questionVo.setOptions(questionOptions);
            questionVo.setRightOption(rightOptions);
            questionVos.add(questionVo);
        }
        return questionVos;
    }

    //    @Override
//    public Iterable<QuestionDto> queryQuestionsList(String keyWord,Integer courseId) {
//        //List<QuestionDto> byTitleLike = questionRepository.findByTitleLike(keyWord);
//        List<QuestionDto> byTitleLikeAndCourseId = questionRepository.findByTitleLikeAndCourseId(keyWord, courseId);
////        return questionRepository.findAll();
//        return byTitleLikeAndCourseId;
//    }


    @Override
    public void insertToElastic() {
        List<Question> questions = questionMapper.selectByExample(new QuestionExample());
        ArrayList<QuestionDto> questionDtos = new ArrayList<>();
        for (Question question : questions) {
            QuestionDto questionDto = new QuestionDto();
            BeanUtil.copyProperties(question, questionDto);
            questionDtos.add(questionDto);
        }
        questionRepository.saveAll(questionDtos);
    }

    public void checkCourse(int courseId){
        Course course = courseMapper.selectByPrimaryKey(courseId);
        if(course == null){
            throw new OnlineExamException(CourseEnums.COURSE_NOT_FOUND);
        }
    }
}

