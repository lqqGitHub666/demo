package com.example.demo.freemarker;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.freemarker
 * @ClassName: Book
 * @Author: liuqingqing
 * @Description:
 * @Date: 2021/11/9 13:39
 */
@Data
public class Book {

    private String id;

    private String name;

    private Author author;

    private String year;

    private String price;

    private String address;

    List<Store> storeList;
}
