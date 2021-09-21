package com.aiz.nowcoder.practice;

/**
 * @ClassName NC4
 * @Description 判断链表中是否有环
 * https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=196&&tqId=37048&rp=1&ru=/ta/job-code-total&qru=/ta/job-code-total/question-ranking
 * @Author Yao
 * @Date Create in 10:08 下午 2021/9/21
 * @Version 1.0
 */
public class NC4 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 快慢两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // 慢指针每次走一步
            slow = slow.next;
            // 快指针每次走两步
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }
        // 否则就是没有环
        return false;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        System.out.println(hasCycle(node));
    }
}

/*
1。快慢指针解决，慢指针每次走一步，块指针每次走两步。如果相遇就说明有环，如果有一个为空说明没有环。
2。存放到集合中，每次存放到时候判断当前节点是否存在。如果存在，说明有环。
 */