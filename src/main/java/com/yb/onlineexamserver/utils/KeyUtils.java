package com.yb.onlineexamserver.utils;

import java.util.Random;

/**
 * @Auther: Yang
 * @Date: 2019/11/14 14:41
 * @Description:
 */
public class KeyUtils {
    /***
     * 使用时间戳生成id
     * @return
     */
    public static synchronized String createUniqueKey(){
//        Random random = new Random();
//        Integer number = random.nextInt(900)+100;
        return String.valueOf(System.currentTimeMillis()+Math.random()*10000);
    }
}
