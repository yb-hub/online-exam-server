package com.yb.onlineexamserver.common.exception;

import com.yb.onlineexamserver.common.result.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 20:16
 * @Description: 控制器异常处理类
 */
@RestControllerAdvice
public class OnlineExamExceptionHandler {
    @ExceptionHandler(OnlineExamException.class)
    public CommonResult handler(OnlineExamException e){
        return CommonResult.fail(e.getCode(), e.getMessage());
    }
}
