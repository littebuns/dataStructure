package org.example;

/**
 * 单链表
 */
public class SingleLinkedList {

    //头节点
    private Node head = new Node(0, "", null);

    /**
     * 不考虑no顺序的添加
     * @param node
     */
    public void add(Node node){
        Node temp = head;
        Node next = temp.next;
        while (true){
            if(null == next){
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 按顺序添加节点
     * @param node
     */
    public void addByOrder(Node node){
        Node temp = head;
        while (true){
            // 到最后也没有 则插入末尾
            if(temp.next == null){
                temp.next = node;
                break;
            }
            //如果下一个编号大于当前编号 则找到node的插入位置
            if(temp.next.no> node.no){
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }

    }

    public void list(){
        System.out.println("当前链表如下所示:");
        System.out.println(head);
        Node temp = head;
        while (null != temp.next) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node node3 = new Node(3, "333");
        Node node5 = new Node(5, "555");
        Node node7 = new Node(7, "777");
        Node node9 = new Node(9, "999");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node3);
        singleLinkedList.list();

        SingleLinkedList orderList = new SingleLinkedList();
        orderList.addByOrder(node3);
        orderList.addByOrder(node7);
        orderList.addByOrder(node5);
        orderList.addByOrder(node9);

        orderList.list();



    }



}



/**
 * 节点
 */
class Node{

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

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
