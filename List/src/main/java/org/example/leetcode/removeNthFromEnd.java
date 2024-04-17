package org.example.leetcode;

/**
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
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        ListNode dummy = new ListNode(0, head);
        //使用一个辅助节点
        ListNode helper = dummy;
        //移动到要删除节点的前一个node
        for (int i = 0; i < length - n; i++) {
            helper = helper.next;
        }
        if(length == 1){
            return null;
        }else {
            helper.next = helper.next.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node = removeNthFromEnd(node1, 2);
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