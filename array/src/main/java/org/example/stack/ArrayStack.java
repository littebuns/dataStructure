package org.example.stack;

public class ArrayStack {

    //栈的最大容量
    private int maxSize;
    //数组模拟栈
    private int[] stackArray;
    //栈顶的指针
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
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
        stackArray[top] = num;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈已空");
        }
        int value = stackArray[top];
        top--;
        return value;
    }

    public void print(){
        for (int i = top; i >= 0 ; i--) {
            System.out.println(stackArray[i]);
        }
    }


    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        int pop = arrayStack.pop();
        System.out.printf("出栈的元素为%d", pop);
        System.out.println();
        arrayStack.print();
    }
}
