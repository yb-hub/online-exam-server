package com.yb.onlineexamserver.common.enums.studentenums;

import com.yb.onlineexamserver.common.enums.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Auther: Yang
 * @Date: 2020/04/05 9:05
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum  StudentEnums implements IErrorCode {
    NOT_EXIST(404,"不存在此学生");
    private int code;
    private String message;
}
