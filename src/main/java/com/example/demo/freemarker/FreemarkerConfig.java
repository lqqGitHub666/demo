package com.example.demo.freemarker;


import freemarker.template.Configuration;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.freemarker
 * @ClassName: FreemarkerConfig
 * @Author: liuqingqing
 * @Description:
 * @Date: 2021/11/9 11:19
 */
public class FreemarkerConfig {

    private static Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
    static {
        cfg.setClassForTemplateLoading(FreemarkerConfig.class, "/templete/");
    }
    public static Configuration instance(){
        return cfg;
    }
}
