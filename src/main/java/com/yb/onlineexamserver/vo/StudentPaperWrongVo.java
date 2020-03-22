package com.yb.onlineexamserver.vo;

import com.yb.onlineexamserver.dto.PaperDetailDto;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: Yang
 * @Date: 2020/02/22 20:35
 * @Description: 试卷错题返回参数
 */
@Data
public class StudentPaperWrongVo {
    private Integer examId;
    private String paperTitle;
    private Integer paperType;
    private Double paperDifficultyDegree;
    private Integer paperTotalQuestion;
    private Integer totalScore;
    private Integer totalSingle;
    private Integer totalMulti;
    private Integer totalJudge;
    private Integer rightSingle;
    private Integer rightMulti;
    private Integer rightJudge;
    private LocalDateTime createTime;
}
