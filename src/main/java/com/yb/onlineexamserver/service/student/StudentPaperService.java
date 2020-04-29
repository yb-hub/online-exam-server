package com.yb.onlineexamserver.service.student;

import com.yb.onlineexamserver.requestparams.student.SubmittedPaperParams;
import com.yb.onlineexamserver.vo.*;

import java.util.List;

public interface StudentPaperService {
    StudentPaperListVo queryPaperByCourseId(Integer id);

    StudentPaperDetailVo queryPaperDetailByPaperId(Integer id);

    int insertPaperResult(SubmittedPaperParams submittedPaper);

    List<StudentPaperWrongVo> queryPaperWrongByStudentId(String studentId,Integer courseId);

    StudentWrongDetailVo queryPaperWrongDetailByExamId(Integer examId);

    List<PaperVo> queryPaperByKeyword(String keyword);

//    StudentPaperResultVo queryPaperResult(SubmittedPaperParams submittedPaper);
}
