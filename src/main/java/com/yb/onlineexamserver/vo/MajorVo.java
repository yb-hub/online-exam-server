package com.yb.onlineexamserver.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: Yang
 * @Date: 2019/11/9 14:59
 * @Description:
 */
@Data
public class MajorVo {

    private Integer id;

    private Integer subjectId;

    private String subjectName;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
