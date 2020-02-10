package com.yb.onlineexamserver.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2020/02/10 19:25
 * @Description: student端练习试卷列表返回参数
 */
@Data
public class StudentPaperListVo {
    private String courseName;
    private List<PaperVo> paperList;
}
