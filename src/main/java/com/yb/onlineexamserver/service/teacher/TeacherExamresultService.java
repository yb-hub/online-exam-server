package com.yb.onlineexamserver.service.teacher;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.vo.ExamResultChartVo;
import com.yb.onlineexamserver.vo.ExamResultVo;

import java.util.List;

public interface TeacherExamresultService {

    Page<ExamResultVo> queryExamresult(String studentId, Integer paperId, Integer page, Integer limit);

    List<ExamResultChartVo> queryExamresultChartData(Integer paperId);
}
