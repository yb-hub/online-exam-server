package com.yb.onlineexamserver.service.teacher;

import com.yb.onlineexamserver.requestparams.TeacherLoginInfo;
import com.yb.onlineexamserver.vo.TeacherVo;

public interface TeacherLoginService {
    TeacherVo login(TeacherLoginInfo teacherLoginInfo);
}
