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

    }

}