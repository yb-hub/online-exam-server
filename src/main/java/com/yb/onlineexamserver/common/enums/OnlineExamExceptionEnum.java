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
   ;

    private int code;
    private String message;
}
