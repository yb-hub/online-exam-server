package com.yb.onlineexamserver.common.enums.courseenums;

import com.yb.onlineexamserver.common.enums.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: Yang
 * @Date: 2019/11/11 12:33
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum CourseEnums implements IErrorCode {
    COURSE_NOT_FOUND(601,"课程不存在");
    private int code;
    private String message;
}
