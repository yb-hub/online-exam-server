package com.yb.onlineexamserver.requestparams;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yb
 * @description
 * @data 2020/4/29
 */
@Data
public class StudentUpdateStatusParams
{
    @NotNull(message = "状态不能为空")
    private Integer isDelete;
}
