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
    BAD_ARGUMENT(400,"参数异常"),
    FILE_IS_NULL(601,"文件不能为空"),
    FILE_TOO_BIG(602,"文件太大，文件不能超过10M"),
    FILE_NOT_PICTURE(603,"不是图片文件"),
    FILE_SAVE_FAIL(604,"图片保存失败")
   ;
    private int code;
    private String message;
}
