package com.yb.onlineexamserver.dao;

import com.github.pagehelper.Page;
import com.yb.onlineexamserver.vo.ExamResultVo;
import org.apache.ibatis.annotations.Param;

public interface ExamResultDao {
    Page<ExamResultVo> queryExamresult(@Param("studentId") String studentId,@Param("paperId") Integer paperId);
}
