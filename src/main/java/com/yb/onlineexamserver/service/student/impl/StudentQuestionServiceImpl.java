package com.yb.onlineexamserver.service.student.impl;

import com.alibaba.fastjson.JSON;
import com.yb.onlineexamserver.dao.student.StudentQuestionDao;
import com.yb.onlineexamserver.dto.QuestionOption;
import com.yb.onlineexamserver.mbg.mapper.QuestionMapper;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.service.student.StudentQuestionService;
import com.yb.onlineexamserver.vo.QuestionVo;
import com.yb.onlineexamserver.vo.StudentQuestionCollectionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/23 19:32
 * @Description:
 */
@Service
public class StudentQuestionServiceImpl implements StudentQuestionService {
    @Autowired
    private StudentQuestionDao studentQuestionDao;
    @Resource
    private QuestionMapper questionMapper;
    @Override
    public int deleteStudentQuestionCollect(String studentId, String questionId) {
        return studentQuestionDao.deleteStudentQuestionCollect(studentId,questionId);
    }

    @Override
    public int insertStudentQuestionCollect(String studentId, String questionId) {
        //todo:判断是否已经收藏
        return studentQuestionDao.insertStudentQuestionCollect(studentId,questionId, LocalDateTime.now(),LocalDateTime.now());
    }

    @Override
    public List<StudentQuestionCollectionVo> queryStudentQuestionCollectByStudentId(String studentId) {
        return studentQuestionDao.queryStudentQuestionCollectByStudentId(studentId);
    }

    @Override
    public List<StudentQuestionCollectionVo> queryStudentQuestionCollectByQuestionType(String studentId, Integer questionType) {
        return studentQuestionDao.queryStudentQuestionCollectByQuestionType(studentId,questionType);
    }

    @Override
    public QuestionVo queryQuestionByQuestionId(String questionId) {
        Question question = questionMapper.selectByPrimaryKey(questionId);
        List<QuestionOption> questionOptions = JSON.parseArray(question.getOptions(), QuestionOption.class);
        List<String> rightOptions = JSON.parseArray(question.getRightOption(),String.class);
        QuestionVo questionVo = new QuestionVo();
        BeanUtils.copyProperties(question, questionVo);
        questionVo.setOptions(questionOptions);
        questionVo.setRightOption(rightOptions);
        return questionVo;
    }
}
