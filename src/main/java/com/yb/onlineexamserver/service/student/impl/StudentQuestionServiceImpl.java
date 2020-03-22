package com.yb.onlineexamserver.service.student.impl;

import com.yb.onlineexamserver.dao.student.StudentQuestionDao;
import com.yb.onlineexamserver.service.student.StudentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public int deleteStudentQuestionCollect(String studentId, String questionId) {
        return studentQuestionDao.deleteStudentQuestionCollect(studentId,questionId);
    }

    @Override
    public int insertStudentQuestionCollect(String studentId, String questionId) {
        return studentQuestionDao.insertStudentQuestionCollect(studentId,questionId, LocalDateTime.now(),LocalDateTime.now());
    }

    @Override
    public List<String> queryStudentQuestionCollectByStudentId(String studentId) {
        return studentQuestionDao.queryStudentQuestionCollectByStudentId(studentId);
    }
}
