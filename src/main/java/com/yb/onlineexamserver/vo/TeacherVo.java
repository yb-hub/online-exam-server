package com.yb.onlineexamserver.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yb
 * @description 教师返回参数
 * @data 2020/4/29
 */
@Data
public class TeacherVo {
    private Integer id;

    private String teacherId;

    private String name;

    private Integer sex;

    private String phone;

    private String email;

    private LocalDateTime lastLoginTime;
}
