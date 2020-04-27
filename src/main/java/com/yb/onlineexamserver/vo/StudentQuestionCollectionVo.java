package com.yb.onlineexamserver.vo;

import lombok.Data;

/**
 * @author yb
 * @description 考生收藏题目返回参数
 * @data 2020/4/27
 */
@Data
public class StudentQuestionCollectionVo {
    private String questionId;
    private String questionTitle;
    private int questionType;
}
