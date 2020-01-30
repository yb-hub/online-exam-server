package com.yb.onlineexamserver.utils;

import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Auther: Yang
 * @Date: 2020/01/30 20:04
 * @Description: 考试时间转换类
 */
public class PaperLimitTimeUtils {
    public static Integer TimeToMinute(String time){
        if(!StringUtils.isEmpty(time)){
            String[] str = time.split(":");
            return Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
        }else{
            return 0;
        }
    }
}
