package com.yb.onlineexamserver.vo;

import com.yb.onlineexamserver.dto.QuestionDto;
import com.yb.onlineexamserver.mbg.model.Question;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/23 13:40
 * @Description: 考生成绩单详情返回参数
 */
@Data
public class StudentWrongDetailVo {
    private Integer examId;

    private Integer paperId;

    private String paperTitle;

    private List<String> singleAnswer;

    private List<List<String>> multiAnswer;

    private List<Integer> judgeAnswer;

    private List<QuestionVo> singleChoiceList;

    private List<QuestionVo> multiChoiceList;

    private List<QuestionVo> judgeChoiceList;
}
