package com.yb.onlineexamserver.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: Yang
 * @Date: 2019/11/11 15:18
 * @Description:
 */
@Data
public class CourseDto {

    private Integer id;

    private Integer majorId;

    private String majorName;

    private String name;

    private BigDecimal credit;

    private String remark;

}
