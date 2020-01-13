package com.yb.onlineexamserver.mbg.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2020/01/10
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paper implements Serializable {
    private Integer id;

    private String title;

    private Integer type;

    private String description;

    private Integer courseId;

    private Integer grade;

    private Integer limitTime;

    private String questionDesciption;

    private Integer totalScore;

    private Long difficultyDegree;

    private Integer totalSingleChoice;

    private Integer totalMultiChoice;

    private Integer totalJudgeChoice;

    private Integer totalQuestion;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}