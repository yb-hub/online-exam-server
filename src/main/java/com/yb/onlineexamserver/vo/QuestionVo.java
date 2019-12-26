package com.yb.onlineexamserver.vo;

import com.yb.onlineexamserver.dto.QuestionOption;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2019/11/14 10:28
 * @Description:
 */
@Data
public class QuestionVo {
    private String id;

    private Integer courseId;

    private String title;

    private Integer type;

    private List<QuestionOption> options;

    private List<String> rightOption;

    private Integer judgeAnswer;

    private Integer score;

    private String analysis;

    private Integer isPaper;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
