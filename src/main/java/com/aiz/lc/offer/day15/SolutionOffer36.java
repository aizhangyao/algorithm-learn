package com.aiz.lc.offer.day15;

import java.util.LinkedList;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer36
 * @description 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @date Create in 16:59 2023/4/17
 */
public class SolutionOffer36 {
    class Node {
        /**
         * Definition for a binary tree node.
         */
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     */

    /**
     * 中序遍历
     * 树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
     */
    Node pre, head;

    private void orderTraversal(Node cur) {
        if (cur == null) {
            return;
        }
        orderTraversal(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        orderTraversal(cur.right);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // dfs
        orderTraversal(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public Node createTree(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Node head = new Node(nums[0]);
        LinkedList<Node> subTree = new LinkedList<>();
        subTree.push(head);
        for (int i = 1; i < nums.length; i++) {
            if (!subTree.isEmpty()) {
                Node cur = subTree.pop();
                if (nums[i] != null) {
                    cur.left = new Node(nums[i]);
                    subTree.add(cur.left);
                }
                i++;
                if (i >= nums.length) {
                    break;
                }
                if (nums[i] != null) {
                    cur.right = new Node(nums[i]);
                    subTree.add(cur.right);
                }

            } else {
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        SolutionOffer36 solutionOffer36 = new SolutionOffer36();
        solutionOffer36.treeToDoublyList(solutionOffer36.createTree(new Integer[]{2, 1, 3}));
    }

    /**
     * answer1 : 回溯 中序遍历 深度优先
     */
}
