package com.aiz.leetcode.top_interview_150;

import com.aiz.base.tree.TreeNode;
import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author ZhangYao
 * @className 从前序与中序遍历序列构造二叉树
 * @description https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @date Create in 21:58 2023/8/24
 */
public class 从前序与中序遍历序列构造二叉树 {
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    /**
     * 构造二叉树
     *
     * @param preorder      前序数组
     * @param inorder       中序数组
     * @param preorderLeft  左孩子的前序数组起始位置 [preorderLeft,preorderRight]
     * @param preorderRight 左孩子的前序数组结束位置
     * @param inorderLeft   右孩子的中序数组起始位置 [inorderLeft,inorderRight]
     * @param inorderRight  右孩子的中序数组结束位置
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder,
                                int preorderLeft, int preorderRight,
                                int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        // 前序遍历的第一个节点就是根节点
        int rootValue = preorder[preorderLeft];
        // 构建根节点
        TreeNode root = new TreeNode(rootValue);
        // 根节点在中序数组中的位置
        int rootIndexInOrder = indexMap.get(rootValue);
        // 得到左子树中的节点数目
        int sizeLeft = rootIndexInOrder - inorderLeft;
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeft, inorderLeft, rootIndexInOrder);
        root.right = myBuildTree(preorder, inorder, preorderLeft + sizeLeft + 1, preorderRight, rootIndexInOrder + 1, inorderRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            // 存储每个值在inorder的位置
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    @Test
    public void test() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        TreeNode expectedResult = TreeNode.init(new int[]{3, 9, 20, TreeNode.NULL, TreeNode.NULL, 15, 7});
        BaseTool.equals(treeNode, expectedResult);
    }

    @Test
    public void test2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode treeNode = buildTree(preorder, inorder);
        TreeNode expectedResult = TreeNode.init(new int[]{-1});
        BaseTool.equals(treeNode, expectedResult);
    }

}
