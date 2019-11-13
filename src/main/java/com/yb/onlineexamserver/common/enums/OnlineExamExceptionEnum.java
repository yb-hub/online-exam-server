package com.yb.onlineexamserver.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 20:01
 * @Description: 异常枚举类
 */
@Getter
@AllArgsConstructor
public enum OnlineExamExceptionEnum implements IErrorCode {
    BAD_ARGUMENT(400,"参数异常")
   ;

    private int code;
    private String message;
}
