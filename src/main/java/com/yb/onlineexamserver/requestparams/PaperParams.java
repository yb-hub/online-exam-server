package com.yb.onlineexamserver.requestparams;

import lombok.Data;

/**
 * @Auther: Yang
 * @Date: 2020/01/10 13:59
 * @Description: 试卷请求参数
 */
@Data
public class PaperParams {

    private String title;

    private Integer type;

    private String description;

    private Integer courseId;

    private Integer grade;

    private Integer limitTime;

    private Integer totalScore;

    private Long difficultyDegree;

    private Integer totalSingleChoice;

    private Integer totalMultiChoice;

    private Integer totalJudgeChoice;

    private Integer totalQuestion;
}
