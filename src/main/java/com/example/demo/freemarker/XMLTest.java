package com.example.demo.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;

import freemarker.template.Template;
import freemarker.template.TemplateException;


public class XMLTest {

    private static Configuration cfg = FreemarkerConfig.instance();

    public static Template getTemplate(String name) {
        Template template = null;
        try {
            template = cfg.getTemplate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return template;
    }

    public static String process(String templatefile, Map<String, Object> param) throws IOException, TemplateException,
            Exception {
        Template template = XMLTest.getTemplate(templatefile);
        StringWriter sw = new StringWriter();
        template.process(param, sw);
        return sw.toString();
    }

    public static String process(String templatefile, Object param) throws IOException, TemplateException,
            Exception {
        Template template = XMLTest.getTemplate(templatefile);
        StringWriter sw = new StringWriter();
        template.process(param, sw);
        return sw.toString();
    }

    public static void main(String[] args) {

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("id", "1");
        responseMap.put("name", "红楼梦");
        responseMap.put("author", "曹雪芹");
        responseMap.put("year", "1862");
        responseMap.put("price", "98");
        Book book = new Book();
        book.setId("1");
        book.setName("红楼梦");
        book.setAuthor("曹雪芹");
        book.setYear("1862");
        book.setPrice("98");
        String resp = null;
        try {
            resp = XMLTest.process("book.ftl", book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resp);
    }

}
