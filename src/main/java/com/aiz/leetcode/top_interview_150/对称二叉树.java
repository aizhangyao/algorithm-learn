package com.aiz.leetcode.top_interview_150;

import com.aiz.base.tree.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 对称二叉树
 * @description https://leetcode.cn/problems/symmetric-tree/
 * @date Create in 21:30 2023/8/24
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.right, q.left) && check(p.left, q.right);
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.init(new int[]{1, 2, 2, 3, 4, 4, 3});
        boolean symmetric = isSymmetric(root);
        assert symmetric;
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.init(new int[]{1, 2, 2, TreeNode.NULL, 3, TreeNode.NULL, 3});
        boolean symmetric = isSymmetric(root);
        assert !symmetric;
    }

}
