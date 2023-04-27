package com.aiz.lc.offer.day19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer68II
 * @description 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @date Create in 00:03 2023/4/24
 */
public class SolutionOffer68II {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson)
                || ((root.val == p.val) || (root.val == q.val)) && (lson || rson)) {
            ans = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    // 存储父节点
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    /**
     * answer1 : 递归
     * 左右子树分别包含p,q。
     * 如果当前节点已经是p或者q,只需要满足左子树或者右子树包含p或者q。
     *
     * answer2 : 存储父节点
     * 判断是否出现或者设计出现次数的问题，可以使用散列表
     *
     */
}
