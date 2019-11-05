package com.yb.onlineexamserver.common.exception;

import com.yb.onlineexamserver.common.result.CommonResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 20:16
 * @Description: 控制器异常处理类
 */
@RestControllerAdvice
public class OnlineExamExceptionHandler {
    //处理公告异常
    @ExceptionHandler(OnlineExamException.class)
    public CommonResult handler(OnlineExamException e) {
        return CommonResult.fail(e.getCode(), e.getMessage());
    }

    //处理参数异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult handler(MethodArgumentNotValidException e) {
        return CommonResult.fail(400, e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
