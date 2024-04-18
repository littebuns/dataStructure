package org.example.stack;

import java.util.Scanner;

public class ArrayStack {

    //栈的最大容量
    private int maxSize;
    //数组模拟栈
    private int[] stack;
    //栈顶的指针
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int num){
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = num;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈已空");
        }
        int value = stack[top];
        top--;
        System.out.printf("出栈的元素为%d", value);
        System.out.println();
        return value;
    }

    public void list(){
        for (int i = top; i >= 0 ; i--) {
            System.out.println(stack[i]);
        }
    }


    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String next = scanner.next();
            switch (next){
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    scanner.close();
                    return;
                case "push":
                    System.out.println("请输入一个值");
                    arrayStack.push(scanner.nextInt());
                    break;
                case "pop":
                    try{
                        arrayStack.pop();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                default:
                    break;
            }

        }

    }
}
