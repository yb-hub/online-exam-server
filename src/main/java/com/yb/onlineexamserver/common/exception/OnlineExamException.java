package com.yb.onlineexamserver.common.exception;

import com.yb.onlineexamserver.common.enums.IErrorCode;
import com.yb.onlineexamserver.common.enums.OnlineExamExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 19:59
 * @Description: 自定义异常类
 */
@Data
@AllArgsConstructor
public class OnlineExamException extends Exception {
    private int code;
    private String message;

    public OnlineExamException(IErrorCode examExceptionEnum){
        this.code = examExceptionEnum.getCode();
        this.message = examExceptionEnum.getMessage();
    }
}
