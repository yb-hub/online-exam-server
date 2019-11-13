package com.yb.onlineexamserver.service.teacher;

import com.yb.onlineexamserver.requestparams.QuestionParam;

/**
 * @Auther: Yang
 * @Date: 2019/11/13 21:53
 * @Description:
 */
public interface QuestionService {
    int insertQuestions(QuestionParam questionParam);
}
