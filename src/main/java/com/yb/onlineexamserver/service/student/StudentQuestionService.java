package com.yb.onlineexamserver.service.student;

import com.yb.onlineexamserver.vo.QuestionVo;
import com.yb.onlineexamserver.vo.StudentQuestionCollectionVo;

import java.util.List;

public interface StudentQuestionService {
    int deleteStudentQuestionCollect(String studentId, String questionId);

    int insertStudentQuestionCollect(String studentId, String questionId);

    List<StudentQuestionCollectionVo> queryStudentQuestionCollectByStudentId(String studentId);

    List<StudentQuestionCollectionVo> queryStudentQuestionCollectByQuestionType(String studentId, Integer questionType);

    QuestionVo queryQuestionByQuestionId(String questionId);
}
