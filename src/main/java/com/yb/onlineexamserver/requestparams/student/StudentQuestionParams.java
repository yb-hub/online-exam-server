package com.yb.onlineexamserver.requestparams.student;

import lombok.Data;

/**
 * @Auther: Yang
 * @Date: 2020/02/23 20:08
 * @Description:
 */
@Data
public class StudentQuestionParams {
    private String studentId;
    private String questionId;
    private Integer isCollect;
}
