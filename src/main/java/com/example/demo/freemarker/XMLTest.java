package com.example.demo.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Store store = new Store();
        store.setName("新华书店安庆店");
        store.setAddress("人民路");
        Store store1 = new Store();
        store1.setName("新华书店杭州店");
        store1.setAddress("滨江路");
        List<Store> storeList = new ArrayList<>();
        storeList.add(store);
        storeList.add(store1);
        Book book = new Book();
        book.setId("1");
        book.setName("红楼梦");
        Author author = new Author();
        author.setName("曹雪芹");
        author.setSex("女");
        book.setAuthor(author);
        book.setYear("1862");
        book.setPrice("98");
        book.setStoreList(storeList);
        Book book1 = new Book();
        book1.setId("2");
        book1.setName("西游记");
        Author author1 = new Author();
        author1.setName("吴承恩");
        author1.setSex("男");
        book1.setAuthor(author1);
        book1.setYear("1663");
        book1.setPrice("100");
        book1.setStoreList(storeList);
//        book.setAddress("1234555555");
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("bookList",bookList);
        String resp = null;
        try {
            resp = XMLTest.process("book.ftl", dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resp);
    }

}
