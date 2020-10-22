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
            throw new RuntimeException("���ʽ��ʽ������");
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
        //����ջ���������pop�������ǽ��
        int res2 = numberStack.pop();
        System.out.printf("���ʽ %s = %d", expression, res2);
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
        int res = 0; // res ���ڴ�ż���Ľ��
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// ע��˳��
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

        //ջ��
        public boolean isFull(){
            return top == maxSize - 1;
        }

        //ջ��
        public boolean isEmpty(){
            return top == -1;
        }

        //��ջ
        public void push(int data){
            if (isFull()){
                System.out.println("ջ�����޷��������");
                return;
            }
            top++;
            stack[top] = data;
        }

        //��ջ
        public int pop(){
            if (isEmpty()){
                System.out.println("ջ�գ������ݵ���");
                return 0;
            }
            int data = stack[top];
            top --;
            return data;
        }

        //��ʾջ������
        public void list(){
            if (isEmpty()){
                System.out.println("ջ��");
                return;
            }
            for (int i = top; i >=0; i --){
                System.out.println(stack[i]);
            }
        }

        //����ջ������
        public int getStackTop(){
            return  stack[top];
        }

    }
}