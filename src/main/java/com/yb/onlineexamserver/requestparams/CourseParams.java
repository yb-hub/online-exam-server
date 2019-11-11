package com.yb.onlineexamserver.requestparams;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Auther: Yang
 * @Date: 2019/11/11 09:35
 * @Description:
 */
@Data
public class CourseParams {

    @NotNull(message = "专业名称不能为空")
    private Integer majorId;
    @NotBlank(message = "课程名称不能为空")
    private String name;
    @NotNull(message = "课程学分不能为空")
    private BigDecimal credit;

    private String remark;

}
