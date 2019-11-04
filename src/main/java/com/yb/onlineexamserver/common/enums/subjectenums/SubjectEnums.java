package com.yb.onlineexamserver.common.enums.subjectenums;

import com.yb.onlineexamserver.common.enums.IErrorCode;
import com.yb.onlineexamserver.common.enums.OnlineExamExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 21:10
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum SubjectEnums implements IErrorCode {
    SUBJECT_IS_EXIST(601,"科目已存在");
    int code;
    String message;
}
