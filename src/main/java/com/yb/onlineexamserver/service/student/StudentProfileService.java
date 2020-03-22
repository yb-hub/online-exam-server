package com.yb.onlineexamserver.service.student;

import com.yb.onlineexamserver.vo.StudentProfileScoreDetailVo;
import com.yb.onlineexamserver.vo.StudentProfileScoreVo;

import java.util.List;

public interface StudentProfileService {
    List<StudentProfileScoreVo> queryStudentScoreById(String studentId);

    StudentProfileScoreDetailVo queryStudentScoreDetailById(String examId);
}
