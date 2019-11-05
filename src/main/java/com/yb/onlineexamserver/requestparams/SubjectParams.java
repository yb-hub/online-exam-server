package com.yb.onlineexamserver.requestparams;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 21:00
 * @Description: 科目请求参数
 */
@Data
public class SubjectParams {
    @NotBlank(message = "科目名称不能为空")
    private String name;
}
