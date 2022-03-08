package com.example.demo.freemarker;

import java.io.StringWriter;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestFreemarker {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{


        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        String templateContent="<bookstore>\n" +
                "    <book id=\"${id}\">\n" +
                "        <name>${name}</name>\n" +
                "        <author>\n" +
                "                <name>${author.name}</name>\n" +
                "                <sex>${author.sex}</sex>\n" +
                "        </author>\n" +
                "        <year>${year}</year>\n" +
                "        <price>${price}1</price>\n" +
                "        <address><#if address??>${address}<#else>1234</#if></address>\n" +
                "   </book>\n" +
                "</bookstore>";
        stringLoader.putTemplate("myTemplate",templateContent);
        cfg.setTemplateLoader(stringLoader);
        Template template = cfg.getTemplate("myTemplate","utf-8");
        Book book = new Book();
        book.setId("1");
        book.setName("红楼梦");
        Author author = new Author();
        author.setName("曹雪芹");
        author.setSex("女");
        book.setAuthor(author);
        book.setYear("1862");
        book.setPrice("98");
        Map<String,String> map = JSON.parseObject(JSON.toJSONString(book),Map.class);
        StringWriter writer = new StringWriter();
        template.process(map, writer);
        System.out.println(writer);
    }

}