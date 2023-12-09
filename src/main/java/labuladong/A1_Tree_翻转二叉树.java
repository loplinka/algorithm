/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_翻转二叉树.java, v 0.1 2023年09月17日 13:15  Baojiang Yang Exp $
 */
public class A1_Tree_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        // 交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
    }

    public TreeNode invertTreeMS(TreeNode root) {
        if (root == null) {
            return null;
        }

        traverseMS(root);
        return root;
    }

    private void traverseMS(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traverseMS(root.left);
        traverseMS(root.right);
    }


}