package com.thankson.common.utils.util;

import java.util.Random;

/**
 * 随机对象
 * @author Thankson
 * @date 2020年2月19日
 */
public class RandomUtil {

    /**
     * 生成随机字符串
     * a-z, 0-9小写字母加数字
     */
    public static String getRandomString() {
        int length = 15;
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}