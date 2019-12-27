package com.yb.onlineexamserver.service.teacher;

import com.yb.onlineexamserver.dto.QuestionDto;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.requestparams.QuestionParam;
import com.yb.onlineexamserver.vo.QuestionVo;

import java.util.List;

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

    List<QuestionVo> queryQuestionsList(String keyWord, Integer courseId, Integer page, Integer pageSize, String sort
    );

    void insertToElastic();

    int insertQuestionsList(List<Question> questionList);

}
