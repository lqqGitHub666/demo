package com.example.demo.data_structures.stack;

import org.springframework.util.StringUtils;

/**
 * @ClassName: Calculator
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/10/21 16:23
 * @Version: 1.0
 */
public class CalculatorDemo {

    public static void main(String[] args) {

    }



}

class Calculator{

    public int calculation(String expression){
        if (StringUtils.isEmpty(expression)){
            return 0;
        }
        char substring = expression.substring(0, 1).charAt(0);
        if (isOper(substring)){
            throw new RuntimeException("表达式格式有问题");
        }
        ArrayStack<Integer> numberStack = new ArrayStack<>(expression.length());
        ArrayStack<Integer> operStack = new ArrayStack<>(expression.length()/2);

        int index = 0;
        while (true){
            char chr = expression.substring(index,index+1).charAt(0);
            if (isOper(chr)) {
                if (chr > operStack.getStackTop()){
                    Integer num1 = numberStack.pop();
                    Integer num2 = numberStack.pop();
                    Integer oper = operStack.pop();
                    int res = cal(num1,num2,oper);
                    numberStack.push(res);
                    operStack.push(chr);
                }
            }else {

            }
        }

    }

    public boolean isOper(char chr){
        return chr == '+' || chr == '-' || chr == '*' ||chr == '/';
    }

    public int priority(char oper){
        if (oper == '+' || oper == '-'){
            return 0;
        }
        if (oper == '*' || oper == '/'){
            return 1;
        }else {
            return -1;
        }
    }

    public int cal(int num1,int num2,int oper){
        int res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    static class ArrayStack<T>{
        private int maxSize;

        private Object [] stack;

        private int top;

        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            this.stack = new Object[maxSize];
            this.top = -1;
        }

        //栈满
        public boolean isFull(){
            return top == maxSize - 1;
        }

        //栈空
        public boolean isEmpty(){
            return top == -1;
        }

        //入栈
        public void push(Object data){
            if (isFull()){
                System.out.println("栈满，无法添加数据");
                return;
            }
            top++;
            stack[top] = data;
        }

        //出栈
        public T pop(){
            if (isEmpty()){
                System.out.println("栈空，无数据弹出");
                return null;
            }
            Object data = stack[top];
            top --;
            return data == null ? null : (T)data;
        }

        //显示栈内数据
        public void list(){
            if (isEmpty()){
                System.out.println("栈空");
                return;
            }
            for (int i = top; i >=0; i --){
                System.out.println(stack[i]);
            }
        }

        //返回栈顶数据
        public T getStackTop(){
            return (T) stack[top];
        }

    }
}