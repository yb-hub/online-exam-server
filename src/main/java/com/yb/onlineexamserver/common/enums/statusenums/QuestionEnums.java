package com.yb.onlineexamserver.common.enums.statusenums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: Yang
 * @Date: 2019/11/13 22:01
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum QuestionEnums {
    SIMPLE_QUESTION(1,"单选题"),
    MULTI_QUESTION(2,"多选题"),
    JUDGE_QUESTION(3,"判断题")
    ;
    private int code;
    private String desc;
}
