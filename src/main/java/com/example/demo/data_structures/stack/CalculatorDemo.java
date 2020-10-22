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
        Calculator calculator = new Calculator();
        calculator.calculation("200*2-100");
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
        ArrayStack numberStack = new ArrayStack(expression.length());
        ArrayStack operStack = new ArrayStack(expression.length()/2);

        int index = 0;
        while (true){
            char chr = expression.substring(index,index+1).charAt(0);
            index++;
            if (isOper(chr)) {
                if (!operStack.isEmpty() && priority(chr) <= priority(operStack.getStackTop())){
                    int num1 = numberStack.pop();
                    int num2 = numberStack.pop();
                    int oper = operStack.pop();
                    int res = cal(num1,num2,oper);
                    numberStack.push(res);
                }
                operStack.push(chr);
            }else {
                String str = String.valueOf(chr);
                while (true){
                    if (index >= expression.length()){
                        break;
                    }
                    char chr1 = expression.substring(index,index+1).charAt(0);
                    if (isOper(chr1)){
                        break;
                    }
                    index++;
                    str = str + String.valueOf(chr1);
                }
                numberStack.push(Integer.valueOf(str));
            }
            if (index>=expression.length()){
                break;
            }
        }
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            int num1 = numberStack.pop();
            int num2 = numberStack.pop();
            int oper = (int)operStack.pop();
            int res = cal(num1,num2,oper);
            numberStack.push(res);
        }
        //将数栈的最后数，pop出，就是结果
        int res2 = numberStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);
        return res2;
    }

    private boolean isOper(int chr){
        return chr == '+' || chr == '-' || chr == '*' ||chr == '/';
    }

    private int priority(int oper){
        if (oper == '+' || oper == '-'){
            return 0;
        }
        if (oper == '*' || oper == '/'){
            return 1;
        }else {
            return -1;
        }
    }

    private int cal(int num1,int num2,int oper){
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

    static class ArrayStack{
        private int maxSize;

        private int [] stack;

        private int top;

        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            this.stack = new int[maxSize];
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
        public void push(int data){
            if (isFull()){
                System.out.println("栈满，无法添加数据");
                return;
            }
            top++;
            stack[top] = data;
        }

        //出栈
        public int pop(){
            if (isEmpty()){
                System.out.println("栈空，无数据弹出");
                return 0;
            }
            int data = stack[top];
            top --;
            return data;
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
        public int getStackTop(){
            return  stack[top];
        }

    }
}