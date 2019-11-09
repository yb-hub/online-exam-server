package com.yb.onlineexamserver.common.enums.majorenums;

import com.yb.onlineexamserver.common.enums.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: Yang
 * @Date: 2019/11/9 14:20
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum MajorEnums implements IErrorCode {
    MAJOR_NOT_FOUND(601,"专业不存在")
    ;
    private int code;
    private String message;
}
