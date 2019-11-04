package com.yb.onlineexamserver.common.result;

import com.yb.onlineexamserver.common.enums.OnlineExamExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 20:05
 * @Description: 统一返回类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    public CommonResult(int code,String message){
        this.code = code;
        this.message =message;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(200, "成功", data);
    }

    public static CommonResult fail(int code,String message){
        return new CommonResult(code,message);
    }

}
