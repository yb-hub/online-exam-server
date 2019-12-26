package com.yb.onlineexamserver.dao;

import com.yb.onlineexamserver.dto.QuestionDto;
import com.yb.onlineexamserver.vo.QuestionVo;

import java.util.List;

public interface QuestionDao {

    List<QuestionDto> queryQuestionsList(String keyWord, Integer courseId, Integer page, Integer pageSize, String sort);

}
