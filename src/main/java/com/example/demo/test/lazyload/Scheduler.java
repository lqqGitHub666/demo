package com.example.demo.test.lazyload;

import com.example.demo.utils.SpringContextUtil;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
/**
 * @author 作者 lqq
 * @ClassName 类名 Scheduled
 * @date 2019/8/8 10:56
 * @注释：
 */
@Component
public class Scheduler {

    @Scheduled(cron = "0/3 * * * * *")
    public void test(){
        System.out.println(this.getClass().getName()+ "进来了");
        SpringContextUtil.getBean(LazyLoadTest.class);
    }

}
