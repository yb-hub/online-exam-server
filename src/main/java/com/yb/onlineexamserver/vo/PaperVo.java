package com.yb.onlineexamserver.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: Yang
 * @Date: 2020/01/31 19:13
 * @Description:
 */
@Data
public class PaperVo{
    private Integer id;

    private String title;

    private Integer type;

    private String description;

    private Integer courseId;

    private Integer grade;

    private Integer limitTime;

    //private String questionDesciption;

    private Integer totalScore;

    private Long difficultyDegree;

    private LocalDateTime updateTime;

}
