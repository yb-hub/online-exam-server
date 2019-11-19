package com.yb.onlineexamserver.service.teacher;

import com.yb.onlineexamserver.dto.QuestionDto;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.requestparams.QuestionParam;

/**
 * @Auther: Yang
 * @Date: 2019/11/13 21:53
 * @Description:
 */
public interface QuestionService {
    int insertQuestions(QuestionParam questionParam);

    int deleteQuestions(String id);

    Question queryQuestionsById(String id);

    int updateQuestions(String id, QuestionParam questionParam);

    Iterable<QuestionDto> queryQuestionsList(String keyWord,Integer courseId);

    void insertToElastic();
}
