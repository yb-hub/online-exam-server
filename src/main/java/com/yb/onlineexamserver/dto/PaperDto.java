package com.yb.onlineexamserver.dto;

import com.yb.onlineexamserver.mbg.model.Question;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/01/10 14:46
 * @Description:
 */
@Data
public class PaperDto {
    private String title;

    private Integer type;

    private String description;

    private Integer courseId;

    private Integer grade;

    private Integer limitTime;

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

    private List<Question> singleChoiceList;

    private List<Question> multiChoiceList;

    private List<Question> judgeChoiceList;

    private List<Question> questionList;

    public void setDifficultyDegree() {
        Double difficutyDegree = new Double(0.00);
        int questionCount = this.questionList.size();
//        int questionCount = this.singleChoiceList.size()+this.multiChoiceList.size()+judgeChoiceList.size();
//        for (Question question : this.singleChoiceList) {
//            difficutyDegree += question.getDifficultyDegree();
//        }
//        for (Question question : this.multiChoiceList) {
//            difficutyDegree += question.getDifficultyDegree();
//        }
//        for (Question question : this.judgeChoiceList) {
//            difficutyDegree += question.getDifficultyDegree();
//        }
        for (Question question : questionList) {
            difficutyDegree += question.getDifficultyDegree();
        }
        this.difficultyDegree =difficutyDegree/questionCount;
    }
}
