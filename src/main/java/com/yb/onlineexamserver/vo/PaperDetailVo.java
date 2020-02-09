package com.yb.onlineexamserver.vo;

import com.yb.onlineexamserver.mbg.model.Question;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/01 21:03
 * @Description: 试卷详情返回值
 */
@Data
public class PaperDetailVo {
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

    private List<QuestionVo> singleChoiceList;

    private List<QuestionVo> multiChoiceList;

    private List<QuestionVo> judgeChoiceList;
}
