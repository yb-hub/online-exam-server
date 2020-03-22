package com.yb.onlineexamserver.service.student;

import java.util.List;

public interface StudentQuestionService {
    int deleteStudentQuestionCollect(String studentId, String questionId);

    int insertStudentQuestionCollect(String studentId, String questionId);

    List<String> queryStudentQuestionCollectByStudentId(String studentId);
}
