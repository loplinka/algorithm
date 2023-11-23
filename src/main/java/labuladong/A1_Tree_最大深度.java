/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_最大深度.java, v 0.1 2023年09月17日 22:53  Baojiang Yang Exp $
 */
public class A1_Tree_最大深度 {
    public static int depth = 0;
    public static int res   = 0;

    /**
     * 二叉树的最大深度
     * 这个方式是回溯算法分祖宗(N皇后问题)
     * @param root
     */
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 进之前加1,即指针进入树的下一层
        depth++;
        // 使用一个res变脸求出最大值
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 返回前-1,即指针返回上一层
        depth--;

    }

    /**
     * 二叉树的最大深度
     *  解法二: 分别求左右子树的最大深度,然后取大,加上1根节点,即为最大深度
     *  此方法是动态规划(凑零钱)的祖宗: 即找规模更小,结构相同的问题,也是分治的思路
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }

    /**
     *     3
     *    / \
     *   9   20
     *      / \
     *     15 7
     *      \
     *      4
     * @return
     */
    public static TreeNode createBinTree() {
        TreeNode leaf7 = new TreeNode(7);
        TreeNode leaf4 = new TreeNode(4);

        TreeNode parent15 = new TreeNode(15, null, leaf4);

        TreeNode left9 = new TreeNode(9, null, null);
        TreeNode right20 = new TreeNode(20, parent15, leaf7);

        return new TreeNode(3, left9, right20);
    }

    public static void main(String[] args) {
        // 测试用例
        TreeNode root = createBinTree();
        traverse(root);
        System.out.println(res);
    }
}