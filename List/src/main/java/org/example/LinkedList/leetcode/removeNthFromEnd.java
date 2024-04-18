package org.example.LinkedList.leetcode;

/**
 * 19
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * -
 * 输入：head = [1], n = 1
 * 输出：[]
 */
public class removeNthFromEnd {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //先遍历一次获取链表的长度
        int length = getLength(head);
        ListNode dummy = new ListNode(0, head);
        //使用一个辅助节点
        ListNode current = dummy;
        //移动到要删除节点的前一个node
        for (int i = 0; i < length - n; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node = removeNthFromEnd(node1, 1);
        System.out.println(node);

    }


}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}