package com.yb.onlineexamserver.service.teacher;

import com.github.pagehelper.Page;
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

    Page<Question> queryQuestionsList();

    void insertToElastic();
}
