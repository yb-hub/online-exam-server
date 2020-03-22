package com.yb.onlineexamserver.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: Yang
 * @Date: 2020/02/17 19:52
 * @Description: 学生成绩单返回参数
 */
@Data
public class StudentProfileScoreVo {
    private Integer id;
    private Integer paperId;
    private String paperTitle;
    private Integer paperType;
    private Double paperDifficultyDegree;
    private Integer paperTotalScore;
    private Integer totalScore;
    private LocalDateTime createTime;
}
