package com.aiz.leetcode.practice;

/**
 * @ClassName Solution430
 * @Description 扁平化多级双向链表   https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * @Author Yao
 * @Date Create in 11:37 上午 2021/9/24
 * @Version 1.0
 */
public class Solution430 {

    public class Node {
        public int val;
        public Node prev; //parent
        public Node next; //right
        public Node child; //left
    }

    /**
     * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
     * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
     *
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    /*
        1。node和node的下一个节点next断开。
        2。node和child相连。
        3。last与next相连。
     */

    public Node dfs(Node node) {
        Node cur = node;
        Node last = null;
        while (cur != null) {
            Node next = cur.next;
            // 如果有子节点，先处理子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);
                next = cur.next;
                //node和child相连。
                cur.next = cur.child;
                cur.child.prev = cur;
                //如果next不空，last与next相连。
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                //将child置空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }

    /*
     1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

     1---2---3---4---5---6--NULL
         |
         7----8---11---12---9---10--NULL

     1---2---7---8---11---12---9---10---3---4---5---6--NULL
     */

}
