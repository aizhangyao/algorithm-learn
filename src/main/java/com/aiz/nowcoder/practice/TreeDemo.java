package com.aiz.nowcoder.practice;

/**
 * @ClassName TreeDemo
 * @Description TODO
 * @Author Yao
 * @Date Create in 9:37 下午 2021/9/14
 * @Version 1.0
 */
public class TreeDemo {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * NC102 在二叉树中找到两个节点的最近公共祖先
     *
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {

        return 0;
    }

    public static void main(String[] args) {


    }

    // 3 [1,2]
    // 9 [2,3,4]
    // 10 [4,5]
    // 12 [3,4,5]
    private int[] findNums(int n){
        int[] result = new int[n];
        if (n <= 2) {
            return new int[]{};
        }
        if (n == 3) {
            return new int[]{1, 2};
        }
        for (int i = n - 1; i > 1; i--) {

        }

        return result;
    }

}
