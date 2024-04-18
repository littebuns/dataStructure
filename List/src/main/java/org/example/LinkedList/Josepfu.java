package org.example.LinkedList;

/**
 * 约瑟夫问题
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.setNode(5);
        circleSingleLinkedList.print();
        circleSingleLinkedList.outLoop(2);
    }

}


/**
 * 环形单向链表
 */
class CircleSingleLinkedList {

    //头节点
    private Node first = null;

    public void setNode(int nums) {
        //辅助节点 指向当前节点
        Node current = null;
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                //如果是第一个节点
                first = node;
                first.next = node;
                current = node;
            } else {
                current.next = node;
                current = node;
                node.next = first;
            }
        }
    }

    /**
     * 获取元素出圈的顺序
     *
     * @param n 出圈的报数值
     */
    public void outLoop(int n) {
        //添加一个辅助节点 指向first节点的前一个 也是链表的最后一个节点
        Node helper = first;
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        //当辅助节点和first节点没有重合(即链表中还有元素)
        while (helper != first) {
            for (int i = 1; i < n; i++) {
                helper = helper.next;
                first = first.next;
            }

            System.out.printf("出列的数据为%d", first.no);
            System.out.println();
            first = first.next;
            helper.next = first;
        }


    }

    public void print() {
        Node current = first.next;
        while (current != first) {
            System.out.println(current);
            current = current.next;
        }
    }

}