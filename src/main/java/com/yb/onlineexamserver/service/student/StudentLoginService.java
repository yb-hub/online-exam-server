package com.yb.onlineexamserver.service.student;

import com.yb.onlineexamserver.requestparams.student.StudentLoginParams;
import com.yb.onlineexamserver.vo.StudentLoginVo;

public interface StudentLoginService {
    StudentLoginVo login(StudentLoginParams studentLoginParam);
}
