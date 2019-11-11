package com.yb.onlineexamserver.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2019/11/11
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    /**
     * 课程id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 专业id
     *
     * @mbg.generated
     */
    private Integer majorId;

    /**
     * 课程名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 课程学分
     *
     * @mbg.generated
     */
    private BigDecimal credit;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}