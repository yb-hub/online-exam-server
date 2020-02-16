package com.yb.onlineexamserver.service.student.impl;

import com.alibaba.fastjson.JSON;
import com.yb.onlineexamserver.common.enums.statusenums.QuestionEnums;
import com.yb.onlineexamserver.dao.student.StudentCourseDao;
import com.yb.onlineexamserver.dao.student.StudentPaperDao;
import com.yb.onlineexamserver.dto.ExamResultDto;
import com.yb.onlineexamserver.dto.PaperDetailDto;
import com.yb.onlineexamserver.dto.QuestionOption;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.requestparams.student.SubmittedPaperParams;
import com.yb.onlineexamserver.service.student.StudentPaperService;
import com.yb.onlineexamserver.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public int insertPaperResult(SubmittedPaperParams submittedPaper) {
        //先生成一个成绩单，并插入到数据库中
        Integer paperId = submittedPaper.getPaperId();
        StudentPaperDetailVo studentPaperDetailVo = queryPaperDetailByPaperId(paperId);
        Integer singleScore = studentPaperDetailVo.getSingleScore();
        Integer multiScore = studentPaperDetailVo.getMultiScore();
        Integer judgeScore = studentPaperDetailVo.getJudgeScore();
        Integer totalScore = 0;
        Integer rightSingle = 0;
        Integer rightMulti = 0;
        Integer rightJudge = 0;
        for (int i = 0; i < submittedPaper.getSingleChoiceAnswer().size(); i++) {
            if(studentPaperDetailVo.getSingleChoiceList().get(i).getRightOption().get(0).equals(submittedPaper.getSingleChoiceAnswer().get(i))){
                totalScore += singleScore;
                rightSingle++;
            }
        }
        for (int i = 0; i < submittedPaper.getMultiChoiceAnswer().size(); i++) {
            if(studentPaperDetailVo.getMultiChoiceList().get(i).getRightOption().equals(submittedPaper.getMultiChoiceAnswer().get(i))){
                totalScore += multiScore;
                rightMulti++;
            }
        }
        for (int i = 0; i < submittedPaper.getJudgeChoiceAnswer().size(); i++) {
            if(studentPaperDetailVo.getJudgeChoiceList().get(i).getJudgeAnswer().equals(submittedPaper.getJudgeChoiceAnswer().get(i))){
                totalScore += judgeScore;
                rightJudge++;
            }
        }
        ExamResultDto examResultDto = new ExamResultDto();
        examResultDto.setPaperId(paperId);
        examResultDto.setStudentId(submittedPaper.getStudentId());
        examResultDto.setTotalScore(totalScore);
        examResultDto.setSingleAnswer(JSON.toJSONString(submittedPaper.getSingleChoiceAnswer().stream().map(item -> {
            if(item == null){
                item = "";
            }
            return item;
        }).collect(Collectors.toList())));
        examResultDto.setMultiAnswer(JSON.toJSONString(submittedPaper.getMultiChoiceAnswer().stream().map(item -> {
            if(item == null){
                String[] str = {""};
                item = Arrays.asList(str);
            }
            return item;
        }).collect(Collectors.toList())));
        examResultDto.setJudgeAnswer(JSON.toJSONString(submittedPaper.getJudgeChoiceAnswer().stream().map(item -> {
            if(item == null){
                item = -1;
            }
            return item;
        }).collect(Collectors.toList())));
        examResultDto.setRightSingle(rightSingle);
        examResultDto.setRightMulti(rightMulti);
        examResultDto.setRightJudge(rightJudge);
        examResultDto.setCreateTime(LocalDateTime.now());
        return studentPaperDao.insertExamResult(examResultDto);
        //获取成绩单id,并在成绩记录表中，插入各题的答案记录
//        Integer examResultId = examResultDto.getId();

//        return 1;
    }
}
