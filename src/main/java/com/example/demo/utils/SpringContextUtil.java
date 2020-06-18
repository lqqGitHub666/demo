package com.example.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 作者 lqq
 * @ClassName 类名 SpringContextUtil
 * @date 2019/6/11 11:30
 * @注释：
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    public static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringContextUtil.context = context;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    /**
     * 根据 beanId 获取 bean 实例
     * @param beanId
     * @return
     */
    public static Object getBean(String beanId) {
        return context.getBean(beanId);
    }

    /**
     * 根据 bean 的实际类型获取 bean 实例
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    /**
     * 获取容器中 bean 实例
     * @param beanId 注入在Spring容器中的bean的ID 默认为类名首字母小写
     * @param clazz bean的实际 class 类型
     */
    public static <T> T getBean(String beanId, Class<T> clazz){
        return context.getBean(beanId, clazz);
    }

}
