package com.yb.onlineexamserver.requestparams.student;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author yb
 * @description
 * @data 2020/4/26
 */
@Data
public class StudentLoginInfo {
    @NotBlank(message = "学生学号不能为空")
    private String studentId;
    @NotBlank(message = "学生密码不能为空")
    private String password;
}
