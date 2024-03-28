package org.example;

import java.util.Stack;

/**
 * 单链表
 */
public class SingleLinkedList {

    //头节点
    private final Node head = new Node(0, "", null);

    /**
     * 不考虑no顺序的添加
     *
     * @param node 添加的节点
     */
    public void add(Node node) {
        Node temp = head;
        Node next = temp.next;
        while (true) {
            if (null == next) {
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 按顺序添加节点
     *
     * @param node
     */
    public void addByOrder(Node node) {
        Node temp = head;
        while (true) {
            // 到最后也没有 则插入末尾
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            //如果下一个编号大于当前编号 则找到node的插入位置
            if (temp.next.no > node.no) {
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void update(Node node) {
        Node temp = head;
        while (null != temp.next) {
            if (temp.next.no == node.no) {
                temp.next.name = node.name;
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(int id) {
        Node temp = head;
        while (null != temp.next) {
            if (temp.next.no == id) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public void list() {
        System.out.println("当前链表如下所示:");
        System.out.println(head);
        Node temp = head;
        while (null != temp.next) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    /**
     * 单链表的反转
     */
    public void reserve() {
        SingleLinkedList newLinkedList = new SingleLinkedList();
        //使用一个辅助node 指向第一个node 可以理解为指针 用于遍历要反转的链表
        Node current = head.next;
        Node next = null;
        while (null != current) {
            //保存下一个节点的引用
            next = current.next;

            //插入到反转链表的head之后
            current.next = newLinkedList.head.next;
            newLinkedList.head.next = current;
            //反转链表向后移动一格
            current = next;
        }
        head.next = newLinkedList.head.next;
    }

    /**
     * 逆序打印单链表
     */
    public void reservePrint(){
        Node current = head.next;
        Stack<Node> stack = new Stack<>();
        while (null != current){
            stack.add(current);
            current = current.next;
        }
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println(pop);
        }

    }

    public static void main(String[] args) {
        Node node3 = new Node(3, "333");
        Node node5 = new Node(5, "555");
        Node node7 = new Node(7, "777");
        Node node9 = new Node(9, "999");
        Node newNode = new Node(3, "newNode");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node3);
        singleLinkedList.list();

        SingleLinkedList orderList = new SingleLinkedList();
        orderList.addByOrder(node3);
        orderList.addByOrder(node7);
        orderList.addByOrder(node5);
        orderList.addByOrder(node9);
        orderList.update(newNode);
        orderList.delete(3);
        orderList.list();
        //反转链表测试
        System.out.println("开始反转链表");
        orderList.reserve();
        orderList.list();
        System.out.println("开始逆向打印链表");
        orderList.reservePrint();



    }


}



