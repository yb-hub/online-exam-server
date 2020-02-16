package com.yb.onlineexamserver.requestparams.student;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/14 19:47
 * @Description: 提交试卷参数
 */
@Data
public class SubmittedPaperParams {
    @NotBlank(message = "学生学号不能为空")
    private String studentId;
    @NotBlank(message = "试卷编号不能为空")
    private Integer paperId;
    private List<String> singleChoiceAnswer;
    private List<List<String>> multiChoiceAnswer;
    private List<Integer> judgeChoiceAnswer;
    @NotNull(message = "考试花费时间不能为空")
    private Double usedTime;
}
