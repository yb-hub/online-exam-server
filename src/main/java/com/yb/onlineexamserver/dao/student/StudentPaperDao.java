package com.yb.onlineexamserver.dao.student;

import com.yb.onlineexamserver.dto.ExamResultDto;
import com.yb.onlineexamserver.dto.PaperDetailDto;
import com.yb.onlineexamserver.dto.StudentWrongDetailDto;
import com.yb.onlineexamserver.vo.PaperVo;
import com.yb.onlineexamserver.vo.StudentPaperWrongVo;
import com.yb.onlineexamserver.vo.StudentWrongDetailVo;

import java.util.List;

public interface StudentPaperDao {
    List<PaperVo> queryPaperByCourseId(Integer id);

    PaperDetailDto queryPaperById(Integer id);

    int insertExamResult(ExamResultDto examResultDto);

    List<StudentPaperWrongVo> queryPaperWrongByStudentId(String studentId,Integer courseId);

    StudentWrongDetailDto queryPaperWrongDetailByExamId(Integer examId);

    List<PaperVo> queryPaperByKeyword(String keyword);
}
