package org.example;

import java.util.Arrays;

/**
 * 队列
 */
public class QueueArray {

    private int front;  //队列头
    private int rear;   //队列尾
    private int maxSize;    //数组的最大长度
    private int[] array;    //数组用于模拟队列

    public QueueArray(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear + 1 == maxSize;
    }

    /**
     * 往队列中添加元素
     * @param item
     */
    public void addQueue(int item){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        array[rear] = item;
        System.out.println(Arrays.toString(array));
    }

    /**
     * 从队列中取出元素
     */
    public void getQueue(){
        if(isEmpty()){
            System.out.println("队列中无元素");
            return;
        }
        front++;
        System.out.printf("取出元素%d", array[front]);
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(5);
        for (int i = 0; i < 5; i++) {
            queueArray.addQueue(i);
            queueArray.getQueue();
        }
        queueArray.addQueue(6);
        queueArray.getQueue();
    }


}

