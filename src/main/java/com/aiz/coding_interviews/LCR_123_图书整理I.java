package com.aiz.coding_interviews;

import com.aiz.base.list.ListNode;
import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className LCR_123_图书整理I
 * @description https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/description/?envId=coding-interviews
 * @date Create in 23:32 2023/10/7
 */
public class LCR_123_图书整理I {
    public int[] reverseBookList(ListNode head) {
        int size = 0;
        ListNode p, q, o;
        p = head;
        q = head;
        o = null;
        int[] b = new int[0];
        if (head == null) {
            return b;
        }
        while (p != null) {
            size++;
            q = p;
            p = p.next;
            q.next = o;
            o = q;
        }
        //反转链表
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = q.val;
            q = q.next;
        }
        return a;
    }

    @Test
    public int[] reverseBookList2(ListNode head) {
        ListNode res = null;
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = res;
            res = cur;
            cur = next;
            size++;
        }
        //反转链表
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = res.val;
            res = res.next;
        }
        return a;
    }

    @Test
    public void test() {
        ListNode head = ListNode.init(new int[]{3, 6, 4, 1});
        BaseTool.equals(reverseBookList2(head), new int[]{1, 4, 6, 3});
    }
}
