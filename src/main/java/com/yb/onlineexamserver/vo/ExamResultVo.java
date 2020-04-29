package com.yb.onlineexamserver.vo;

import lombok.Data;

/**
 * @Auther: Yang
 * @Date: 2020/04/29 22:18
 * @Description: 考试成绩返回参数
 */
@Data
public class ExamResultVo {
    private String studentId;
    private String studentName;
    private Integer paperId;
    private String paperTitle;
    private Integer totalScore;
    private Integer resultScore;
}
