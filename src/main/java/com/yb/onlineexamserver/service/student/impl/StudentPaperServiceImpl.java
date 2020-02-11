package com.yb.onlineexamserver.service.student.impl;

import com.alibaba.fastjson.JSON;
import com.yb.onlineexamserver.common.enums.statusenums.QuestionEnums;
import com.yb.onlineexamserver.dao.student.StudentCourseDao;
import com.yb.onlineexamserver.dao.student.StudentPaperDao;
import com.yb.onlineexamserver.dto.PaperDetailDto;
import com.yb.onlineexamserver.dto.QuestionOption;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.service.student.StudentPaperService;
import com.yb.onlineexamserver.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/10 19:21
 * @Description:
 */
@Service
public class StudentPaperServiceImpl implements StudentPaperService {
    @Autowired
    private StudentPaperDao studentPaperDao;
    @Autowired
    private StudentCourseDao studentCourseDao;
    @Override
    public StudentPaperListVo queryPaperByCourseId(Integer id) {
        StudentPaperListVo studentPaperListVo = new StudentPaperListVo();
        List<PaperVo> paperVos = studentPaperDao.queryPaperByCourseId(id);
        CourseVo courseVo = studentCourseDao.queryCourseById(id);
        studentPaperListVo.setCourseName(courseVo.getName());
        studentPaperListVo.setPaperList(paperVos);
        return studentPaperListVo;
    }

    @Override
    public StudentPaperDetailVo queryPaperDetailByPaperId(Integer id) {
        PaperDetailDto paperDetailDto = studentPaperDao.queryPaperById(id);
        StudentPaperDetailVo paperDetailVo = new StudentPaperDetailVo();
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
}
