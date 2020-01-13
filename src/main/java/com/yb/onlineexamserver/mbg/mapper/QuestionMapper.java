package com.yb.onlineexamserver.mbg.mapper;

import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.mbg.model.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2020/01/10
*/
public interface QuestionMapper {
    long countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}