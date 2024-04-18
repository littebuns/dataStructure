package org.example.LinkedList;

/**
 * 双向链表
 */
public class DoubleSingleLinkedList {

    //头节点
    public Node2 head = new Node2(0, "");

    public void add(Node2 node){
        Node2 current = head;
        while (true){
            if(current.next == null){
                node.pre = current;
                current.next = node;
                break;
            }
            current = current.next;
        }
    }

    public void list() {
        System.out.println("当前链表如下所示:");
        System.out.println(head);
        Node2 temp = head;
        while (null != temp.next) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoubleSingleLinkedList list = new DoubleSingleLinkedList();
        Node2 node3 = new Node2(3, "333");
        Node2 node5 = new Node2(5, "555");
        Node2 node7 = new Node2(7, "777");
        Node2 node9 = new Node2(9, "999");
        Node2 newNode = new Node2(3, "newNode");
        list.add(node3);
        list.add(node5);
        list.list();
    }



}

/**
 * 双向链表的 node 节点
 */
class Node2 {

    public int no;
    public String name;
    public Node2 next;
    public Node2 pre;

    public Node2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public Node2() {
    }

    @Override
    public String toString() {
        return "Node2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
