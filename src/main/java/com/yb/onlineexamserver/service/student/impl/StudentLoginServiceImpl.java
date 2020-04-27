package com.yb.onlineexamserver.service.student.impl;

import com.yb.onlineexamserver.dao.student.StudentDao;
import com.yb.onlineexamserver.mbg.mapper.StudentMapper;
import com.yb.onlineexamserver.mbg.model.Student;
import com.yb.onlineexamserver.requestparams.student.StudentLoginInfo;
import com.yb.onlineexamserver.service.student.StudentLoginService;
import com.yb.onlineexamserver.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yb
 * @description
 * @data 2020/4/26
 */
@Service
public class StudentLoginServiceImpl implements StudentLoginService {
    @Resource
    private StudentDao studentDao;

    @Override
    public StudentVo login(StudentLoginInfo studentLoginInfo) {
        return studentDao.login(studentLoginInfo);
    }
}
