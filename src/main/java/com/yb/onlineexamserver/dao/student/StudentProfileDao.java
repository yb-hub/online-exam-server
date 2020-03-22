package com.yb.onlineexamserver.dao.student;

import com.yb.onlineexamserver.vo.StudentProfileScoreDetailVo;
import com.yb.onlineexamserver.vo.StudentProfileScoreVo;

import java.util.List;

public interface StudentProfileDao {
    List<StudentProfileScoreVo> queryStudentScoreById(String studentId);

    StudentProfileScoreDetailVo queryStudentScoreDetailById(String examId);
}
