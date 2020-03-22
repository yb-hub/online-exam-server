package com.yb.onlineexamserver.dto;

import lombok.Data;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/23 14:18
 * @Description:
 */
@Data
public class StudentWrongDetailDto {
    private Integer examId;

    private Integer paperId;

    private String paperTitle;

    private String singleAnswer;

    private String multiAnswer;

    private String judgeAnswer;
}
