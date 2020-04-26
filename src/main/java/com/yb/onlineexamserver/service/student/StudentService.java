package com.yb.onlineexamserver.service.student;

import com.yb.onlineexamserver.requestparams.student.StudentUpdateParams;
import com.yb.onlineexamserver.requestparams.student.StudentUpdatePwdParams;
import com.yb.onlineexamserver.vo.StudentVo;

public interface StudentService {
    StudentVo updateStudent(String studentId, StudentUpdateParams studentUpdateParams);

    void updatePassword(String studentId, StudentUpdatePwdParams studentUpdatePwdParams);
}
