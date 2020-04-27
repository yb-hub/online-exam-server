package com.yb.onlineexamserver.dao.student;

import com.yb.onlineexamserver.vo.StudentQuestionCollectionVo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentQuestionDao {
    int deleteStudentQuestionCollect(String studentId, String questionId);

    int insertStudentQuestionCollect(String studentId, String questionId, LocalDateTime createTime, LocalDateTime updateTime);

    List<StudentQuestionCollectionVo> queryStudentQuestionCollectByStudentId(String studentId);

    List<StudentQuestionCollectionVo> queryStudentQuestionCollectByQuestionType(@Param("studentId") String studentId, @Param("questionType") Integer questionType);
}
