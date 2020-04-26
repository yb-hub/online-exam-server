package com.yb.onlineexamserver.service.student;

import com.yb.onlineexamserver.requestparams.student.StudentLoginInfo;
import com.yb.onlineexamserver.vo.StudentVo;

public interface StudentLoginService {
    StudentVo login(StudentLoginInfo studentLoginInfo);
}
