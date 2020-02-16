package com.yb.onlineexamserver.service.student;

import com.yb.onlineexamserver.requestparams.student.SubmittedPaperParams;
import com.yb.onlineexamserver.vo.StudentPaperDetailVo;
import com.yb.onlineexamserver.vo.StudentPaperListVo;

public interface StudentPaperService {
    StudentPaperListVo queryPaperByCourseId(Integer id);

    StudentPaperDetailVo queryPaperDetailByPaperId(Integer id);

    int insertPaperResult(SubmittedPaperParams submittedPaper);

//    StudentPaperResultVo queryPaperResult(SubmittedPaperParams submittedPaper);
}
