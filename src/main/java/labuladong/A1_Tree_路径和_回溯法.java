/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version 路径和: A1_Tree_路径和.java, v 0.1 2023年09月17日 12:42  Baojiang Yang Exp $
 */
public class A1_Tree_路径和_回溯法 {

    static boolean found  = false;
    static int     curSum = 0;
    static int     target = 0;

    /**
     * 是否存在和targetSum相等的路径和
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        target = targetSum;
        traverse(root);
        return found;
    }

    /**
     * 遍历
     * @param root
     */
    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        curSum += root.val;
        // 是否是叶子节点
        if (root.left == null && root.left == null) {
            if (target == curSum) {
                found = true;
            }
        }
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        curSum -= root.val;
    }

    public static void main(String[] args) {
        // 写出上述算法的测试用例
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int target = 22;

        System.out.println(hasPathSum(root, target));
    }

}