package com.yb.onlineexamserver.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Auther: Yang
 * @Date: 2019/11/11 15:18
 * @Description:
 */
@Data
public class CourseVo {

    private Integer id;

    private Integer majorId;

    private String majorName;

    private String name;

    private BigDecimal credit;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
