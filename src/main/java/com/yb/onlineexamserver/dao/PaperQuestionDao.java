package com.yb.onlineexamserver.dao;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/01/30 20:21
 * @Description: 试卷题目dao
 */
public interface PaperQuestionDao {
    int insertPaperQuestions(Integer paperId, List<String> questionIdList);
}
