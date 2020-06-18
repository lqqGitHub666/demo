package com.example.demo.test.testenum;

public enum EnumDemo {

    A("haha"),
    B("hehe");
    int b = 10;
    private String a;

    EnumDemo(String a) {
        this.a = a;
    }

    public static void main(String[] args) {
        System.out.println(EnumDemo.A.b);
    }
}
