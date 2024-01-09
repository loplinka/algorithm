/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.Queue;

import com.google.common.collect.Lists;

import base.TreeNode;

/**
 *
 * @author Baojiang Yang
 * @version : A2_Tree_最小深度_层序遍历法.java, v 0.1 2023年09月26日 17:57  Baojiang Yang Exp $
 */
public class A2_Tree_最小深度_层序遍历法 {

    /**
     *
     * leeCode 111. 二叉树的最小深度
     *
     * 最小深度
     *
     * 迭代法
     * @param root
     * @return
     */
    public static int minDepthIt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = Lists.newLinkedList();
        q.offer(root);

        // root本身就是一层,深度初始化为1
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                // 判断是否达到终点
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            depth++;
        }

        return depth;
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public static int minDepthRe(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepthRe(root.right) + 1;
        } else if (root.right == null) {
            return minDepthRe(root.left) + 1;
        } else {
            return Math.min(minDepthRe(root.left), minDepthRe(root.right)) + 1;
        }
    }

    /**
     * 动态规划法
     * @param root
     * @return
     */
    public static int minDepthDp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepthDp(root.right) + 1;
        }
        if (root.right == null) {
            return minDepthDp(root.left) + 1;
        }
        int leftMinDepth = minDepthDp(root.left);
        int rightMinDepth = minDepthDp(root.right);
        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepthIt(root));
        System.out.println(minDepthRe(root));
        System.out.println(minDepthDp(root));
    }

}