package com.aiz.leetcode.top_interview_150;


import com.aiz.base.tree.TreeNode;
import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author ZhangYao
 * @version 1.0
 * @className 二叉树展开为链表
 * @description https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * @date Create in 17:20 2024/4/1
 */
public class 二叉树展开为链表 {

    public void flatten(TreeNode root) {
        // 先序遍历
        ArrayList<TreeNode> list = new ArrayList<>();
        dfs(root, list);

        // 二叉树链化
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    private void dfs(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.init(new int[]{1, 2, 5, 3, 4, TreeNode.NULL, 6});
        二叉树展开为链表 o = new 二叉树展开为链表();
        o.flatten(root);
        TreeNode expectedResult = TreeNode.init(new int[]{1, TreeNode.NULL, 2, TreeNode.NULL, 3, TreeNode.NULL, 4, TreeNode.NULL, 5, TreeNode.NULL, 6});
        BaseTool.equals(root, expectedResult);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.init(new int[]{});
        二叉树展开为链表 o = new 二叉树展开为链表();
        o.flatten(root);
        TreeNode expectedResult = TreeNode.init(new int[]{});
        BaseTool.equals(root, expectedResult);
    }

    @Test
    public void test3() {
        TreeNode root = TreeNode.init(new int[]{0});
        二叉树展开为链表 o = new 二叉树展开为链表();
        o.flatten(root);
        TreeNode expectedResult = TreeNode.init(new int[]{0});
        BaseTool.equals(root, expectedResult);
    }
}
