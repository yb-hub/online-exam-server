package com.yb.onlineexamserver.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yb
 * @description
 * @data 2020/4/26
 */
@Data
public class StudentVo {
    private Integer id;

    private String name;

    private String studentId;

    private Integer classId;

    private String className;

    private Integer majorId;

    private String majorName;

    private String phoneNumber;

    private String email;

    private Integer sex;

    private Integer isDelete;

    private LocalDateTime createTime;

}
