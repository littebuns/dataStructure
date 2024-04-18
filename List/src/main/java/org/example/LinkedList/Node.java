package org.example.LinkedList;

/**
 * 节点的定义
 */
public class Node {

    public int no;
    public String name;
    public Node next;   //指向下一个节点

    public Node(int no, String name, Node next) {
        this.no = no;
        this.name = name;
        this.next = next;
    }

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

}
