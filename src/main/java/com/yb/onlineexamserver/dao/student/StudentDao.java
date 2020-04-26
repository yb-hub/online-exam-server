package com.yb.onlineexamserver.dao.student;

import com.yb.onlineexamserver.vo.StudentLoginVo;

public interface StudentDao {
    StudentLoginVo queryStudentByStudentIdAndPwd(String studentId,String password);
}
