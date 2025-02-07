package com.aiz.coding_interviews;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYao
 * @className LCR_154_复杂链表的复制
 * @description https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/?envId=coding-interviews
 * @date Create in 22:25 2023/10/9
 */
public class LCR_154_复杂链表的复制 {

    public static class Node {
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

    @Test
    public void test() {

    }
}
