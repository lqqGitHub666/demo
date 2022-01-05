package com.example.demo.freemarker;

import java.io.StringWriter;

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
                "        <author>${author}</author>\n" +
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
        book.setAuthor(null);
        book.setYear("1862");
        book.setPrice("98");
        StringWriter writer = new StringWriter();
        template.process(book, writer);
        System.out.println(writer);
    }

}