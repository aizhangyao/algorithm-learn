package com.aiz.leetcode.top_interview_150;

import com.aiz.base.list.ListNode;
import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 删除排序链表中的重复元素II
 * @description https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * @date Create in 10:04 2023/8/23
 */
public class 删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.init(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode node = deleteDuplicates(head);
        ListNode expectedResult = ListNode.init(new int[]{1, 2, 5});
        BaseTool.equals(node, expectedResult);
    }

    @Test
    public void test2() {
        ListNode head = ListNode.init(new int[]{1, 1, 1, 2, 3});
        ListNode node = deleteDuplicates(head);
        ListNode expectedResult = ListNode.init(new int[]{2, 3});
        BaseTool.equals(node, expectedResult);
    }
}
