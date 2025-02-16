package com.aiz.base.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhangYao
 * @className TreeNode 二叉树
 * @description Definition for a binary tree node.
 * https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/
 * @date Create in 18:54 2023/8/24
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 二叉树前序遍历
     *
     * @param root 根节点
     * @return 按前序遍历返回
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preRecursive(root, results);
        return results;
    }

    private void preRecursive(TreeNode node, List<Integer> results) {
        if (node == null) {
            return;
        }
        results.add(node.val);
        preRecursive(node.left, results);
        preRecursive(node.right, results);
    }

    /**
     * 二叉树中序遍历
     *
     * @param root 根节点
     * @return 按中序遍历返回
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        inRecursive(root, results);
        return results;
    }

    private void inRecursive(TreeNode node, List<Integer> results) {
        if (node == null) {
            return;
        }
        inRecursive(node.left, results);
        results.add(node.val);
        inRecursive(node.right, results);
    }

    /**
     * 二叉树后序遍历(使用栈)
     * 从根节点开始依次迭代，弹出栈顶元素输出到输出列表中，然后依次压入它的所有孩子节点，
     * 按照从上到下、从左至右的顺序依次压入栈中。
     * 因为深度优先搜索后序遍历的顺序是从下到上、从左至右，所以需要将输出列表逆序输出。
     *
     * @param root 根节点
     * @return 按后序遍历返回
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    /*
     * 首先根元素入队
     * 当队列不为空的时候
     *  求当前队列的长度 Si
     *  依次从队列中取 Si 个元素进行拓展，然后进入下一次迭代
     */

    /**
     * 二叉树的层序遍历
     * 即逐层地，从左到右访问所有节点。
     *
     * @param root 根节点
     * @return 按层序遍历返回
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (null == root) {
            return results;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> rowNodes = new LinkedList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.pollFirst();
                assert node != null;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                rowNodes.add(node.val);
            }
            results.add(rowNodes);
        }
        return results;
    }


    private int answer = 0;

    /**
     * 给定一个二叉树，请寻找它的最大深度。
     * “自顶向下” 的解决方案
     *
     * @param root  根节点
     * @param depth 当前层数
     */
    private void maximumDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximumDepth(root.left, depth + 1);
        maximumDepth(root.right, depth + 1);
    }


    /**
     * 给定一个二叉树，请寻找它的最大深度。
     * “自底向上” 的解决方案
     *
     * @param root 根节点
     * @return 返回树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    /**
     * 对称二叉树：镜像对称
     * 递归方法：
     * 它们的两个根结点具有相同的值
     * 每个树的右子树都与另一个树的左子树镜像对称
     *
     * @param root 根节点
     * @return 返回是否是对称二叉树
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
    /*
     * 要是使用迭代方式的话需要使用队列
     */

    public final static int NULL = -10086;

    public static TreeNode init(int[] array) {
        if (array == null || array.length == 0) {
            return new TreeNode();
        }
        List<TreeNode> nodes = new ArrayList<>(array.length);
        for (int obj : array) {
            nodes.add(new TreeNode(obj));
        }
        for (int i = 0; i < array.length / 2 - 1; i++) {
            TreeNode node = nodes.get(i);
            if (node.val == NULL) {
                continue;
            }
            node.left = nodes.get(i * 2 + 1);
            node.right = nodes.get(i * 2 + 2);
        }
        // 只有当总节点数是奇数时，最后一个父节点才有右子节点
        int lastPNodeIndex = array.length / 2 - 1;
        if (lastPNodeIndex >= 0) {
            TreeNode lastPNode = nodes.get(lastPNodeIndex);
            // 左孩子节点
            lastPNode.left = nodes.get(lastPNodeIndex * 2 + 1);
            if (array.length % 2 != 0) {
                lastPNode.right = nodes.get(lastPNodeIndex * 2 + 2);
            }
        }
        return nodes.get(0);
    }


    private static TreeNode initTreeNode() {
        // F B G A D null I null C E H null
        // 6 2 7 1 4 null 9 null 3 5 8 null
        TreeNode nodeC = new TreeNode(3);
        TreeNode nodeE = new TreeNode(5);
        TreeNode nodeH = new TreeNode(8);

        TreeNode nodeA = new TreeNode(1);
        TreeNode nodeD = new TreeNode(4, nodeC, nodeE);
        TreeNode nodeI = new TreeNode(9, nodeH, null);

        TreeNode nodeB = new TreeNode(2, nodeA, nodeD);
        TreeNode nodeG = new TreeNode(7, null, nodeI);

        return new TreeNode(3, nodeB, nodeG);
    }

    public static void main(String[] args) {
        TreeNode root = initTreeNode();
        TreeNode treeNode = new TreeNode();

        // 测试前序遍历
        System.out.println(treeNode.preorderTraversal(root));

        // 测试中序遍历
        System.out.println(treeNode.inorderTraversal(root));

        // 测试后序遍历(使用栈)
        System.out.println(treeNode.postorderTraversal(root));

        // 测试层序遍历
        System.out.println(treeNode.levelOrder(root));

        // 请寻找它的最大深度(自顶向下)
        treeNode.maximumDepth(root, 0);
        System.out.println(treeNode.answer);

        // 请寻找它的最大深度(自底向上)
        System.out.println(treeNode.maxDepth(root));

        // 测试镜像对称
        System.out.println(treeNode.isSymmetric(root));
    }

    /**
     * 当遇到二叉树的时候一般输入是以数组的形式给出，不方便调试，因此本文总结一下如何将数组转换为二叉树结构，以方便打印调试过程。
     */

    /**
     * 从数组的某个位置的元素开始生成树
     */
    public static TreeNode createTree(Integer[] array, int start) {
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[start]);

        int leftNode = start >> 2 + 1;
        int rightNode = start >> 2 + 2;

        if (leftNode > array.length - 1) {
            root.left = null;
        } else {
            root.left = createTree(array, leftNode);
        }
        if (rightNode > array.length - 1) {
            root.right = null;
        } else {
            root.right = createTree(array, rightNode);
        }
        return root;
    }

    public static TreeNode getTreeNode(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        LinkedList<TreeNode> subTree = new LinkedList<>();
        subTree.push(head);
        for (int i = 1; i < nums.length; i++) {
            if (!subTree.isEmpty()) {
                TreeNode cur = subTree.pop();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    subTree.add(cur.left);
                }
                i++;
                if (i >= nums.length) {
                    break;
                }
                if (nums[i] != null) {
                    cur.right = new TreeNode(nums[i]);
                    subTree.add(cur.right);
                }

            } else {
                break;
            }
        }
        return head;
    }

}

/*
 * 如何遍历一棵树?
 * 1.深度优先搜索（DFS）
 * 在这个策略中，我们采用 深度 作为优先级，以便从跟开始一直到达某个确定的叶子，然后再返回到达另一个分支。
 * 深度优先搜索策略又可以根据根节点、左孩子和右孩子的相对顺序被细分为先序遍历，中序遍历和后序遍历。
 * 2.宽度(广度)优先搜索（BFS）
 * 我们按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。
 */
