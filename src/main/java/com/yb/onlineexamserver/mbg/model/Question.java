package com.yb.onlineexamserver.mbg.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2019/11/13
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question implements Serializable {
    /**
     * 题目id
     *
     * @mbg.generated
     */
    private String id;

    /**
     * 课程id(数据结构)
     *
     * @mbg.generated
     */
    private Integer courseId;

    /**
     * 题目名称
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 题目类型（1为选择题，2为多项选择，3为判断题，4为简答题）
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     * 选项（json字符串）
     *
     * @mbg.generated
     */
    private String options;

    /**
     * 选择题的正确选项(数组，可能是多选题)
     *
     * @mbg.generated
     */
    private String rightOption;

    /**
     * 判断题的正确答案（1为正确，0为错误）
     *
     * @mbg.generated
     */
    private Integer judgeAnswer;

    /**
     * 题目的分值
     *
     * @mbg.generated
     */
    private Integer score;

    /**
     * 题目解析
     *
     * @mbg.generated
     */
    private String analysis;

    /**
     * 是否是考试题目（0为练习题，1为考试题）
     *
     * @mbg.generated
     */
    private Integer isPaper;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}