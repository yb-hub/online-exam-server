package com.yb.onlineexamserver.requestparams.student;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yb
 * @description 考生修改密码请求参数
 * @data 2020/4/26
 */
@Data
public class StudentUpdatePwdParams {
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "新密码不能为空")
    private String newPassword;
    @NotBlank(message = "请重复新密码")
    private String newPasswordConfirm;
}
