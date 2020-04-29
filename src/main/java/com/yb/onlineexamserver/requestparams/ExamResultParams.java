package com.yb.onlineexamserver.requestparams;

import lombok.Data;

/**
 * @Auther: Yang
 * @Date: 2020/04/29 22:13
 * @Description: 考试成绩请求参数
 */
@Data
public class ExamResultParams {
    private Integer page;
    private Integer limit;
    private String studentId;
    private Integer paperId;
}
