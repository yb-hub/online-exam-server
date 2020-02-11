package com.yb.onlineexamserver.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/11 19:28
 * @Description: student端试卷详情返回参数
 */
@Data
public class StudentPaperDetailVo {
    private Integer id;

    private String title;

    private Integer type;

    private String description;

    private Integer courseId;

    private Integer grade;

    private String limitTime;

    private String questionDesciption;

    private Integer totalScore;

    private Double difficultyDegree;

    private Integer singleScore;

    private Integer multiScore;

    private Integer judgeScore;

    private Integer totalSingleChoice;

    private Integer totalMultiChoice;

    private Integer totalJudgeChoice;

    private Integer totalQuestion;

    private LocalDateTime updateTime;

    private List<QuestionVo> singleChoiceList;

    private List<QuestionVo> multiChoiceList;

    private List<QuestionVo> judgeChoiceList;
}
