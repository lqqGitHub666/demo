package com.example.demo.utils.codingChallenge;

import org.springframework.util.Assert;

import java.util.ArrayList;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestPartyUtil
 * @date 2019/10/30 19:36
 * @注释：
 */
public class TestPartyUtil {

    public static void main(String[] args) {
        ScheduleMeetingService scheduleMeetingService = new ScheduleMeetingService();
        boolean  o = scheduleMeetingService.scheduleMeeting("23:30","00:30",Memory.getBookedTimeList());
        Assert.isTrue(!o,"程序异常");
        System.out.println("执行成功");
        boolean  o1 = scheduleMeetingService.scheduleMeeting("13:00","14:30",Memory.getBookedTimeList());
    }
}
