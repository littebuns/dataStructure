package org.example;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * 环型队列
 * 会充分利用数组的空间
 */
public class CircleQueue {

    private int front;  //队列头
    private int rear;   //队列尾
    private int maxSize;    //数组的最大长度
    private int[] array;    //数组用于模拟队列

    public CircleQueue(int length) {
        this.maxSize = length;
        array = new int[length];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 往队列中添加元素
     *
     * @param item
     */
    public void addQueue(int item) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        array[rear] = item;
        rear = (rear + 1) % maxSize;
        System.out.println(rear);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 从队列中取出元素
     */
    public void getQueue() {
        if (isEmpty()) {
            System.out.println("队列中无元素");
            return;
        }
        System.out.printf("取出元素%d", array[front]);
        front = (front + 1) % maxSize;
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入队列的大小");
        CircleQueue arrayQueue = new CircleQueue(scanner.nextInt());
        System.out.println("e: 退出");
        System.out.println("a: 添加");
        System.out.println("g: 取出");
        boolean flag = true;
        while (flag) {
            String next = scanner.next();
            switch (next) {
                case "a":
                    System.out.println("输入要添加的元素");
                    arrayQueue.addQueue(scanner.nextInt());
                    break;
                case "g":
                    arrayQueue.getQueue();
                    break;
                case "e":
                    flag = false;
                    break;
                default:
                    break;

            }
        }


    }


}
