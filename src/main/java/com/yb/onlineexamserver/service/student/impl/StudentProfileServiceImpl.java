package com.yb.onlineexamserver.service.student.impl;

import com.yb.onlineexamserver.dao.student.StudentProfileDao;
import com.yb.onlineexamserver.service.student.StudentProfileService;
import com.yb.onlineexamserver.vo.StudentProfileScoreDetailVo;
import com.yb.onlineexamserver.vo.StudentProfileScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/17 19:51
 * @Description:
 */
@Service
public class StudentProfileServiceImpl implements StudentProfileService {
    @Autowired
    private StudentProfileDao studentProfileDao;
    @Override
    public List<StudentProfileScoreVo> queryStudentScoreById(String studentId) {
        List<StudentProfileScoreVo> studentProfileScoreVos = studentProfileDao.queryStudentScoreById(studentId);
        return studentProfileScoreVos;
    }

    @Override
    public StudentProfileScoreDetailVo queryStudentScoreDetailById(String examId) {
        return studentProfileDao.queryStudentScoreDetailById(examId);
    }
}
