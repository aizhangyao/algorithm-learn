package com.aiz.nowcoder.practice;

/**
 * @ClassName NC9
 * @Description 二叉树中是否存在节点和为指定值的路径
 * @Author Yao
 * @Date Create in 11:38 下午 2021/9/25
 * @Version 1.0
 */
public class NC9 {


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode node = new TreeNode();
        node.val = 3;
        root.left = node;

        System.out.println(hasPathSum(root, 4));
    }
}
