package com.yb.onlineexamserver.requestparams;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther: Yang
 * @Date: 2019/11/9 13:57
 * @Description:
 */
@Data
public class MajorParams {
    @NotNull(message = "科目id不能为空")
    private Integer subjectId;
    @NotBlank(message = "专业名称不能为空")
    private String name;
}
