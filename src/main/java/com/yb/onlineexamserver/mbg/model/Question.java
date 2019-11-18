package com.yb.onlineexamserver.mbg.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

/**
* Created by Mybatis Generator on 2019/11/13
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "onlineexam",type ="question")
public class Question implements Serializable {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private Integer courseId;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;

    private Integer type;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String options;

    private String rightOption;

    private Integer judgeAnswer;

    private Integer score;

    private String analysis;

    private Integer isPaper;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}