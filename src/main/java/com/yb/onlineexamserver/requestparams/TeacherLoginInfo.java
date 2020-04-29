package com.yb.onlineexamserver.requestparams;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yb
 * @description 教师登录请求参数
 * @data 2020/4/29
 */
@Data
public class TeacherLoginInfo {
    @NotBlank(message = "学生学号不能为空")
    private String username;
    @NotBlank(message = "学生密码不能为空")
    private String password;
}
