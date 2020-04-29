package com.yb.onlineexamserver.service.teacher;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.vo.ExamResultVo;

public interface TeacherExamresultService {

    Page<ExamResultVo> queryExamresult(String studentId, Integer paperId, Integer page, Integer limit);
}
