package com.aiz.leetcode.top_interview_150;

import com.aiz.base.list.ListNode;
import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 分隔链表
 * @description https://leetcode.cn/problems/partition-list/
 * @date Create in 11:56 2023/8/24
 */
public class 分隔链表 {

    public ListNode partition(ListNode head, int x) {
        // 弄个2新链表dummy，发现小的就插在dummyLow的末尾,发现大的就插在dummyHigh的末尾，然后在head中干掉。最后 dummyLow + dummyHigh
        // 1 4 3 2 5 2
        // 4 3 5
        ListNode dummyLow = new ListNode(-1), nodeL = dummyLow;
        // 1 2 2
        ListNode dummyHigh = new ListNode(-1), nodeH = dummyHigh;
        while (head != null) {
            if (head.val < x) {
                nodeL.next = head;
                nodeL = nodeL.next;
            } else {
                nodeH.next = head;
                nodeH = nodeH.next;
            }
            head = head.next;
        }
        nodeL.next = dummyHigh.next;
        nodeH.next = null;
        return dummyLow.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.init(new int[]{1, 4, 3, 2, 5, 2});
        ListNode node = partition(head, 3);
        ListNode expectedResult = ListNode.init(new int[]{1, 2, 2, 4, 3, 5});
        BaseTool.equals(node, expectedResult);
    }

    @Test
    public void test2() {
        ListNode head = ListNode.init(new int[]{2, 1});
        ListNode node = partition(head, 2);
        ListNode expectedResult = ListNode.init(new int[]{1, 2});
        BaseTool.equals(node, expectedResult);
    }
}
