package com.yb.onlineexamserver.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: Yang
 * @Date: 2020/02/15 21:49
 * @Description: 考试成绩单
 */
@Data
public class ExamResultDto {
    private Integer id;
    private Integer paperId;
    private String studentId;
    private Integer totalScore;
    private String singleAnswer;
    private String multiAnswer;
    private String judgeAnswer;
    private Integer rightSingle;
    private Integer rightMulti;
    private Integer rightJudge;
    private LocalDateTime createTime;
}
