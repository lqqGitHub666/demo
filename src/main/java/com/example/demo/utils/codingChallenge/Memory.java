package com.example.demo.utils.codingChallenge;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shc
 * @date 2019-10-30
 *
 * 功能：模拟持久化存储
 */
public class Memory {

    private static final List<String[]> booked = new LinkedList<>();
    static {
        // 题目场景一，模拟已被预约的时间段
        booked.add(new String[]{"9:00","10:00"});
        booked.add(new String[]{"11:00","12:00"});
        booked.add(new String[]{"13:00","13:30"});

        // 预置已预约时间段的使用状态，由 JVM 保证并发安全
        for (String[] bookedTime : booked) {
            ScheduleMeetingService.setUsedFlags(bookedTime);
        }
    }

    /**
     * 增加预约记录，由业务保证并发安全
     * @param book 新增预约记录
     */
    public static void add(String[] book) {
        booked.add(book);
    }

    /**
     * 获取已预约的所有记录，由业务保证并发安全
     * @return 已预约记录列表
     */
    public static List getBookedTimeList() {
        return booked;
    }
}
