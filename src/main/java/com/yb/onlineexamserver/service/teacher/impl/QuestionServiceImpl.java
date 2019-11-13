package com.yb.onlineexamserver.service.teacher.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.yb.onlineexamserver.mbg.mapper.QuestionMapper;
import com.yb.onlineexamserver.mbg.model.Question;
import com.yb.onlineexamserver.requestparams.QuestionParam;
import com.yb.onlineexamserver.service.teacher.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Auther: Yang
 * @Date: 2019/11/13 21:53
 * @Description:
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int insertQuestions(QuestionParam questionParam) {
        Question question = new Question();
        BeanUtil.copyProperties(questionParam, question);
        question.setCreateTime(LocalDateTime.now());
        question.setUpdateTime(LocalDateTime.now());
        question.setOptions(JSON.toJSONString(questionParam.getOptions()));
        question.setRightOption(JSON.toJSONString(questionParam.getRightOption()));
        return questionMapper.insertSelective(question);
    }
}
