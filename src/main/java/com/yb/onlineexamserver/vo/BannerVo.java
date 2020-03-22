package com.yb.onlineexamserver.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: Yang
 * @Date: 2020/03/20 8:29
 * @Description: 轮播图返回参数
 */
@Data
public class BannerVo {
    private Integer id;

    private String title;

    private Integer type;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
