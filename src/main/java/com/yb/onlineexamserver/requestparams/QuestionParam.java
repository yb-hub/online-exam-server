package com.yb.onlineexamserver.requestparams;

import com.yb.onlineexamserver.dto.QuestionOption;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2019/11/13 21:40
 * @Description:
 */
@Data
public class QuestionParam {

    private Integer courseId;
    @NotBlank(message = "题目名称不能为空")
    private String title;
    @NotNull(message = "题目类型不能为空,1为单选题，2为多选题，3为判断题")
    private Integer type;

    private List<QuestionOption> options;

    private List<String> rightOption;

    private Integer judgeAnswer;
    //@NotNull(message = "题目分值不能为空")
    private Integer score;

    private String analysis;

    private Long difficultyDegree;

    private Integer isPaper;
}
