package com.yb.onlineexamserver.dto;

import lombok.Data;


/**
 * @Auther: Yang
 * @Date: 2019/11/18 22:14
 * @Description:
 */
@Data
//@Document(indexName = "onlineexam",type ="question")
public class QuestionDto {
    //@Id
    private String id;

    //@Field(type = FieldType.Keyword)
    private Integer courseId;

    private String courseName;

    //@Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;

    private Integer type;
   // @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String options;

    private String rightOption;

    private Integer judgeAnswer;

    private Long difficultyDegree;

    private Integer score;

    private String analysis;

    private Integer isPaper;

}
