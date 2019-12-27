package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.dto.QuestionDto;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.requestparams.QuestionParam;
import com.yb.onlineexamserver.vo.QuestionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionDao {

    List<QuestionDto> queryQuestionsList(String keyWord, Integer courseId, Integer page, Integer pageSize, String sort);

    int insertQuestionsList(@Param("questionList") List<Question> questionList);

}
