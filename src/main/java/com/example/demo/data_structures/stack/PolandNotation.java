package com.example.demo.data_structures.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: PolandNotation
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/10 9:53
 * @Version: 1.0
 */
public class PolandNotation {

    public static void main(String[] args) {

//        String ss = "3 4 + 5 * 6 -";
//        List<String> listString = getListString(ss);
//        System.out.println(listString);
//        System.out.println("res = "+calculate(listString));
//
        String aa = "1+((2+3)*4-1*1)-5";
        List<String> strings = toInfixExpressionList(aa);
        List<String> strings1 = parseSuffixExpressionList(strings);
        System.out.println(strings);
        Collections.reverse(strings1);
        strings1.forEach(s -> System.out.print(s+"  "));
        System.out.println("\nres="+calculate(strings1));
    }

    private static List<String> getListString(String str){
        String[] strArray = str.split(" ");
        List<String> stringList = new ArrayList<>(strArray.length);
        for (String s : strArray) {
            stringList.add(s);
        }
        return stringList;
    }

    private static Integer calculate(List<String> stringList){
        Stack<String> strStack = new Stack<>();
        for (String item : stringList) {
            if (item.matches("\\d+")){
                strStack.push(item);
            }else {
                int num2 = Integer.valueOf(strStack.pop());
                int num1 = Integer.valueOf(strStack.pop());
                int res;
                if (item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num1 - num2;
                }else if (item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("....");
                }
                strStack.push("" + res);
            }
        }
        return Integer.valueOf(strStack.pop());
    }


    public static List<String> toInfixExpressionList(String expression){
        List<String> ls = new ArrayList<>(expression.length());
        int index = 0;
        String str;
        char c;
        do {
            if ((c = expression.charAt(index)) <48 || c > 57){
                ls.add("" + c);
                index ++;
            }else {
                str = "";
                while (index<expression.length() && (c = expression.charAt(index)) >= 48 && c <= 57){
                    str += c;
                    index ++;
                }
                ls.add(str);
            }
        }while (index < expression.length());
        return ls;
    }

    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for (int i = 0; i < ls.size(); i++) {
            String s = ls.get(i);
            if (s.matches("\\d+")) {
                s2.push(s);
            } else {
                if (s.equals(")")) {
                    while (!s1.peek().equals("(")) {
                        s2.push(s1.pop());
                    }
                    s1.pop();
                } else if (s1.empty() || s.equals("(") || s1.peek().equals("(") || priority(s.charAt(0)) > priority(s1.peek().charAt(0))) {
                    s1.push(s);
                } else {
//                    while (!s1.empty() && priority(s.charAt(0)) <= priority(s1.peek().charAt(0))){
//                        s2.push(s1.pop());
//                    }
//                    s1.push(s);
                   s2.push(s1.pop());
                   i--;
                }
            }
        }
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        List<String> ss = new ArrayList<>(ls.size());
        while (!s2.empty()){
            String sss = s2.pop();
            ss.add(sss);
        }
        return ss;
    }

    private static int priority(int oper){
        if (oper == '+' || oper == '-'){
            return 0;
        }
        if (oper == '*' || oper == '/'){
            return 1;
        }else {
            return -1;
        }
    }
}
