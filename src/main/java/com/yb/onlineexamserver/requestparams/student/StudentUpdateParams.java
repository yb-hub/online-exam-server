package com.yb.onlineexamserver.requestparams.student;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author yb
 * @description 修改考试信息请求参数
 * @data 2020/4/26
 */
@Data
public class StudentUpdateParams {
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Max(value = 1,message = "性别只能是0或1，0代表女 1代表男")
    @Min(value = 0,message = "性别只能是0或1，0代表女 1代表男")
    private Integer sex;
    @Email(message = "邮箱格式不对")
    private String email;
    @Pattern(regexp = "^1[3456789]\\d{9}$")
    private String phoneNumber;
}
