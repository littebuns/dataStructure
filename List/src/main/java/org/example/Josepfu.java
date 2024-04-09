package org.example;

/**
 * 约瑟夫问题
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.setNode(5);
        circleSingleLinkedList.print();
    }

}


/**
 * 环形单向链表
 */
class CircleSingleLinkedList {

    //头节点
    private Node first = new Node(-1);

    public void setNode(int nums) {
        //辅助节点 指向当前节点
        Node current = null;
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if(i==1){
                //如果是第一个节点
                first.next = node;
                node.next = first;
                current = node;
            }else {
                current.next = node;
                current = node;
                node.next = first;
            }
        }
    }

    public void print(){
        Node current = first.next;
        while (current != first){
            System.out.println(current);
            current = current.next;
        }
    }

}