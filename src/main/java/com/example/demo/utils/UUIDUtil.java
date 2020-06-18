package com.example.demo.utils;

import java.util.UUID;

/**
 * @Auther: hqf
 * @Date: 2018/10/10 17:26
 * @Description:
 */
public class UUIDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
