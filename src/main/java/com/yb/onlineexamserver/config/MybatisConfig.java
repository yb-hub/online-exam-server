package com.yb.onlineexamserver.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 21:47
 * @Description: mybatis配置类
 */
@Configuration
@MapperScan("com.yb.onlineexamserver.mbg.mapper")
public class MybatisConfig {
}
