package com.yb.onlineexamserver.vo;

import lombok.Data;

/**
 * @author yb
 * @description 成绩数据统计返回参数
 * @data 2020/4/30
 */
@Data
public class ExamResultChartVo {
    private Integer paperId;
    private String  paperTitle;
    private String studentId;
    private String studentName;
    private Integer totalScore;
    private Integer rightSingle;
    private Integer rightMulti;
    private Integer rightJudge;
}
