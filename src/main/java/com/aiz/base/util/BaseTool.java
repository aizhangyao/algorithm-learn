package com.aiz.base.util;

import com.aiz.base.list.ListNode;
import com.aiz.base.tree.TreeNode;

import java.util.List;
import java.util.Objects;

/**
 * @author ZhangYao
 * @className AizTool
 * @description 判断相等的工具
 * @date Create in 16:56 2023/8/10
 */
public class BaseTool {
    public static void equals(int[] a, int[] b) {
        assert a.length == b.length;
        for (int i = 0; i < a.length; i++) {
            assert a[i] == b[i];
        }
    }

    public static void equals(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                assert a[i][j] == b[i][j];
            }
        }
    }

    public static void equals(List<?> listA, List<?> listB) {
        assert listA.size() == listB.size();
        for (int j = 0; j < listA.size(); j++) {
            if (listA.get(j) instanceof List) {
                equals((List<?>) listA.get(j), (List<?>) listB.get(j));
            } else {
                assert Objects.equals(listA.get(j), listB.get(j));
            }
        }
    }

    /**
     * 判断两个链表是否相等
     */
    public static void equals(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            assert l1.val == l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }
        assert l1 == l2;
    }

    /**
     * 判断两颗二叉树是否相等
     */
    public static boolean equals(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return equals(p.left, q.left) && equals(p.right, q.right);
        }
        return false;
    }

    /**
     * 判断两个字符串是否相等
     */
    public static boolean equals(String a, String b) {
        return Objects.equals(a, b);
    }
}
