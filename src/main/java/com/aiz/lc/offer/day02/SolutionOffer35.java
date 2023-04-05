package com.aiz.lc.offer.day02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer35
 * @description 剑指 Offer 35. 复杂链表的复制
 * https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @date Create in 22:27 2023/4/5
 */
public class SolutionOffer35 {
    /**
     * Definition for a Node.
     */
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

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return map.get(head);
    }




    /**
     * answer1 : hash表，原本node和新node的映射关系
     *          回溯 + 哈希表
     * answer2 : 迭代 + 节点拆分 1->1->2->2->3->3->null
     *          三次遍历 第一次拼接next.第二次拼接random.第三次拆分出来
     */
}
