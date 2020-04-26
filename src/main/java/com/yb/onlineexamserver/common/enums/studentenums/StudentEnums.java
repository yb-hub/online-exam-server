package com.yb.onlineexamserver.common.enums.studentenums;

import com.yb.onlineexamserver.common.enums.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yb
 * @description 考生异常枚举类
 * @data 2020/4/26
 */
@Getter
@AllArgsConstructor
public enum StudentEnums implements IErrorCode {
    STUDENT_NOT_FOUND(404,"用户不存在");
    private int code;
    private String message;
}
