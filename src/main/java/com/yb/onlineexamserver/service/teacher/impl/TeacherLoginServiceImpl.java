package com.yb.onlineexamserver.service.teacher.impl;

import com.yb.onlineexamserver.common.enums.teacherenums.TeacherEnums;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.dao.TeacherDao;
import com.yb.onlineexamserver.requestparams.TeacherLoginInfo;
import com.yb.onlineexamserver.service.teacher.TeacherLoginService;
import com.yb.onlineexamserver.vo.TeacherVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yb
 * @description
 * @data 2020/4/29
 */
@Service
public class TeacherLoginServiceImpl implements TeacherLoginService {

    @Resource
    private TeacherDao teacherDao;

    @Override
    public TeacherVo login(TeacherLoginInfo teacherLoginInfo) {
        TeacherVo teacherVo = teacherDao.login(teacherLoginInfo);
        if(teacherVo == null){
            throw new OnlineExamException(TeacherEnums.TEACHER_NOT_FOUND);
        }
        return teacherVo;
    }
}
