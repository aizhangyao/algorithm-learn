package com.aiz.leetcode.top_interview_150;

import com.aiz.base.tree.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 相同的树
 * @description https://leetcode.cn/problems/same-tree/
 * @date Create in 21:08 2023/8/24
 */
public class 相同的树 {
    /**
     * 深度优先
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    @Test
    public void test() {
        TreeNode p = TreeNode.init(new int[]{1, 2, 3});
        TreeNode q = TreeNode.init(new int[]{1, 2, 3});
        boolean sameTree = isSameTree(p, q);
        assert sameTree;
    }

    @Test
    public void test2() {
        TreeNode p = TreeNode.init(new int[]{1, 2});
        TreeNode q = TreeNode.init(new int[]{1, TreeNode.NULL, 2});
        boolean sameTree = isSameTree(p, q);
        assert !sameTree;
    }

    @Test
    public void test3() {
        TreeNode p = TreeNode.init(new int[]{1, 2, 1});
        TreeNode q = TreeNode.init(new int[]{1, 1, 2});
        boolean sameTree = isSameTree(p, q);
        assert !sameTree;
    }
}
