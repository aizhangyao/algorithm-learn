package com.aiz.lc.offer.day19;

import com.aiz.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYao
 * @className 二叉搜索树的最近公共祖先I
 * @description Offer 68 - I. 二叉搜索树的最近公共祖先
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @date Create in 23:35 2023/4/23
 */
public class 二叉搜索树的最近公共祖先I {

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);

        TreeNode result = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); ++i) {
            if (qPath.get(i) == pPath.get(i)) {
                result = qPath.get(i);
            } else {
                break;
            }
        }
        return result;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        ArrayList<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            // 利用二叉搜索树的特点
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

    /**
     * answer1 : 二叉树
     */
}
