package com.yb.onlineexamserver.dao.student;

import com.yb.onlineexamserver.mbg.model.Student;
import com.yb.onlineexamserver.requestparams.student.StudentLoginInfo;
import com.yb.onlineexamserver.vo.StudentVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface StudentDao {
    StudentVo login(@Param("studentLoginInfo") StudentLoginInfo studentLoginInfo);

    StudentVo queryStudentById(@Param("studentId") String studentId);

    Student queryStudentByStudentIdAndPwd(@Param("studentId") String studentId,@Param("password") String password);

    void updatePassword(@Param("studentId") String studentId,@Param("newPassword") String newPassword);

    void updateStudent(@Param("studentId") String studentId,@Param("status") Integer status);
}
