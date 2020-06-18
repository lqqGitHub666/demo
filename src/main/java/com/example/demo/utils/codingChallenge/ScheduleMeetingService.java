package com.example.demo.utils.codingChallenge;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

/**
 * @author shc
 * @data 2019-10-30
 *
 * 功能：会议预约
 */
public class ScheduleMeetingService {

    /**
     * 一天 24 小时且预约都是整点或半点开始，最小粒度为 30 分钟
     * 这样每小时只有两个粒度单位，24 小时共 48 个单位
     *
     * 利用数组标记这 48 个时间单位的使用情况，时间复杂度 O(1)
     * 0：未使用
     * 1：已使用
     */
    private static final byte[] used = new byte[48];

    /**
     * 已使用标记，将已被使用的那个 30 分钟所对应的索引位置置位
     */
    private static final byte USED = 1;

    /**
     * 时间粒度单位 30 分钟
     */
    private static final int UNIT = 30;

    /**
     * 当天的零点
     */
    private static final String ZERO_TIME = "00:00";

    /**
     * 当天 24 点
     */
    private static final String FULL_TIME = "24:00";

    /**
     * 设置已预约时间段的使用状态
     * @param bookedTime 单个已预约时间段起止时间
     */
    public static void setUsedFlags(String[] bookedTime) {
        // 获取该时间段对应的索引范围
        int[] idxRange = getIndexRange(bookedTime[0], bookedTime[1]);
        for (int i = idxRange[0]; i < idxRange[1]; i++) {
            // 范围内的所有索引位置置位
            used[i] = USED;
        }
    }

    /**
     * @param startTime 请求预约的起始时间
     * @param endTime 请求预约的结束时间
     * @param scheduledMeetings 已经存在的会议预约记录
     * @return true 预约成功，预约记录增加一条存储
     *         false 时间段冲突，预约失败
     */
    boolean scheduleMeeting(String startTime, String endTime, List<String[]> scheduledMeetings) {
        LocalTime startLocalTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("H:m"));
        // TODO 午夜 12 点作为 endTime，该方式能预约，但第 48 个索引位未置位
//        if (FULL_TIME.equals(endTime) || ZERO_TIME.equals(endTime)) {
//            // 30分钟作为最小粒度，那么对于午夜12点，这个时刻的传参只能是 24:00 或者 00:00
//            endTime = "23:59";
//        }
        LocalTime endLocalTime = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("H:m"));
        if (!endLocalTime.isAfter(startLocalTime)) {
            // 结束时间应晚于起始时间
            return false;
        }
        // 获取该时间段对应的索引范围，仅针对入参的计算，无状态
        int[] idxRange = getIndexRange(startTime, endTime);
        /*
        对于并发的请求，共享变量需同步
        另外，这里是先判断再执行的场景，即共享状态的复合操作，利用并发容器也不能避免竞态条件
         */
        synchronized (used) {
            for (int i = idxRange[0]; i < idxRange[1]; i++) {
                if (used[i] == USED) {
                    // 如果当前预约时间段中某个 30 分钟数组位置已被使用，则预约失败
                    return false;
                }
            }
            // 预约的时间段没有被使用，则存储该记录到已存在的会议预约中
            String[] newBookTime = {startTime,endTime};
            Memory.add(newBookTime);
            // 对新预约的时段，设置其索引位的状态
            setUsedFlags(newBookTime);
            // 包装引用的发布，解决对象发布安全，这里返回的预约记录不可被修改
            scheduledMeetings = Collections.unmodifiableList(Memory.getBookedTimeList());
            for (String[] scheduledMeeting : scheduledMeetings) {
                for (String s : scheduledMeeting) {
                    System.out.println(s);
                }
            }
        }
        return true;
    }

    /**
     * 获取入参的起止时间点在 48 个索引上的范围，纯计算，无状态
     * @param startTime 起始时间点
     * @param endTime 结束时间点
     * @return 索引范围（左闭右开）
     */
    private static int[] getIndexRange(String startTime, String endTime) {
        // 返回起止时间点应落在数组上的索引范围
        int[] range = new int[2];
        // 起始时间到当天零点的分钟数
        Duration duration = Duration.between(LocalTime.parse(ZERO_TIME), LocalTime.parse(startTime, DateTimeFormatter.ofPattern("H:m")));
        int minute = (int)duration.toMinutes();
        // 记录起始时间点应落在数组的索引位置
        range[0] = minute / UNIT;

        // 处理结束时间点的索引位置
        duration = Duration.between(LocalTime.parse(ZERO_TIME), LocalTime.parse(endTime, DateTimeFormatter.ofPattern("H:m")));
        minute = (int)duration.toMinutes();
        range[1] = minute / UNIT;

        return range;
    }

}
