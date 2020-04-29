package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.requestparams.TeacherLoginInfo;
import com.yb.onlineexamserver.vo.TeacherVo;
import org.apache.ibatis.annotations.Param;

public interface TeacherDao {
    TeacherVo login(@Param("teacherLoginInfo") TeacherLoginInfo teacherLoginInfo);
}
