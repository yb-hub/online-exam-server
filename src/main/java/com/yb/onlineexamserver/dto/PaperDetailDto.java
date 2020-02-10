package com.yb.onlineexamserver.dto;

import com.yb.onlineexamserver.mbg.model.Question;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/01 21:13
 * @Description:
 */
@Data
public class PaperDetailDto {
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

    private Integer status;

    private Integer singleScore;

    private Integer multiScore;

    private Integer judgeScore;

    private Integer totalSingleChoice;

    private Integer totalMultiChoice;

    private Integer totalJudgeChoice;

    private Integer totalQuestion;

    private List<Question> totalQuestionList;
}
