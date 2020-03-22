package com.yb.onlineexamserver.dao.student;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentQuestionDao {
    int deleteStudentQuestionCollect(String studentId, String questionId);

    int insertStudentQuestionCollect(String studentId, String questionId, LocalDateTime createTime, LocalDateTime updateTime);

    List<String> queryStudentQuestionCollectByStudentId(String studentId);
}
