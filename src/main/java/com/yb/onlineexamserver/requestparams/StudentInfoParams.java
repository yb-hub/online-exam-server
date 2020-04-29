package com.yb.onlineexamserver.requestparams;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yb
 * @description 新增学生请求参数
 * @data 2020/4/29
 */
@Data
public class StudentInfoParams {
    @NotBlank(message = "学生学号不能为空")
    private String studentId;
    private String name;
    private String phoneNumber;
    private String email;
    private Integer sex;
    @NotBlank(message = "学生密码不能为空")
    private String password;
}
