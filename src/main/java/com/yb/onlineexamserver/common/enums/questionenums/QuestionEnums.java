package com.yb.onlineexamserver.common.enums.questionenums;

import com.yb.onlineexamserver.common.enums.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: Yang
 * @Date: 2019/11/14 10:41
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum  QuestionEnums implements IErrorCode {
    QUESTION_NOT_FOUND(601,"题目不存在")
    ;
    private int code;
    private String message;
}
