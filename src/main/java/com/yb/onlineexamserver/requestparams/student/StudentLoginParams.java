package com.yb.onlineexamserver.requestparams.student;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: Yang
 * @Date: 2020/04/04 17:42
 * @Description:
 */
@Data
public class StudentLoginParams {
    @NotBlank(message = "学生学号不能为空")
    @Length(min=8,max = 8,message = "学生学号是八位数字")
    private String studentId;
    @NotBlank(message = "学生密码不能为空")
    private String password;
}
