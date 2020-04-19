package com.thankson.common.utils.util;

import java.util.HashMap;

/**
 * 字符串工具类
 *
 * @author Thankson
 * @date 2020年2月19日
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 首字母大写
     */
    public static String upperFirstChar(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * 首字母小写
     */
    public static String lowerFirstChar(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /**
     * 移除table_ tab_ tb_
     */
    public static String replaceFirstTab(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        return str.replaceFirst("table_", "")
                .replaceFirst("tab_", "")
                .replaceFirst("tb_", "");
    }

    /**
     * 字符串转驼峰
     *
     * @param str
     * @return
     */
    public static String replace_(String str) {
        //根据下划线分割
        String[] split = str.split("_");
        //循环组装
        StringBuilder result = new StringBuilder(split[0]);
        if (split.length > 1) {
            for (int i = 1; i < split.length; i++) {
                result.append(upperFirstChar(split[i]));
            }
        }
        return result.toString();
    }
}
