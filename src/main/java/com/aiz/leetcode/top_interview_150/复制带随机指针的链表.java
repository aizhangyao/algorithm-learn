package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 复制带随机指针的链表
 * @description https://leetcode.cn/problems/copy-list-with-random-pointer/description/
 * @date Create in 22:13 2023/8/22
 */
public class 复制带随机指针的链表 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 三次遍历，第一次先处理next，第二次处理random，第三次断链
        // 处理next
        Node current = head;
        while (current != null) {
            Node node = new Node(current.val);
            // current -> node -> next
            // node插入current后面
            Node next = current.next;
            current.next = node;
            node.next = next;
            current = next;
        }
        // 处理random
        current = head;
        while (current != null) {
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next == null ? null : current.next.next;
        }
        // 断链 剥离出来
        current = head;
        Node temp = new Node(-1);
        Node res = temp;
        while (current != null) {
            // current -> node -> next
            Node node = current.next;
            temp.next = node;
            temp = temp.next;
            if (node == null) {
                current = null;
            } else {
                current.next = node.next;
                current = node.next;
            }
        }
        return res.next;
    }

    @Test
    public void test() {
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        Node res = copyRandomList(node0);
        System.out.println();
    }
}
