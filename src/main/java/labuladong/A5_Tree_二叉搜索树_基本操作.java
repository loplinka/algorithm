/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version 二叉搜索树的基本操作: A5_Tree_二叉搜索树_基本操作.java, v 0.1 2023年10月19日 00:55  Baojiang Yang Exp $
 */
public class A5_Tree_二叉搜索树_基本操作 {

    /**
     * leeCode 700
     * 二叉搜索树中的搜索
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            // 到右子树去找
            return searchBST(root.right, val);
        } else {
            // 到左子树去找
            return searchBST(root.left, val);
        }
    }

    /**
     * leeCode 701
     * BST的插入
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 但你输入的root是空的,就说明到预期的位置,返回一个新的节点,上一个指针会接收
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            // 到右子树去找
            root.right = insertIntoBST(root.right, val);
        } else {
            // 到左子树去找
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public TreeNode deleteTreeNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            // 情况1, Key比root的val都大
            root.right = deleteTreeNode(root.right, key);
        } else if (root.val > key) {
            // 情况2, Key比root的val都小
            root.left = deleteTreeNode(root.left, key);
        } else {
            // 情况3, Key就是root的val
            if (root.left == null) {
                // 情况3.1, 左子树为空,直接返回右子树
                return root.right;
            }
            if (root.right == null) {
                // 情况3.2, 右子树为空,直接返回左子树
                return root.left;
            }
            // 情况3.3, 左右子树都不为空,找到左子树中最大的节点,替换到当前节点
            TreeNode leftMax = maxNode(root.left);
            // 删除右子树中最小的节点
            root.right = removeMax(root.left);
            leftMax.left = root.left;
            leftMax.right = root.right;
            root = leftMax;

        }
        return root;
    }

    /**
     * BST中查找最大节点
     * @param root
     * @return
     */
    public TreeNode maxNode(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    /**
     * 删除以root为根的BST中最大的节点
     * @param root
     * @return
     */
    public TreeNode removeMax(TreeNode root) {
        if (root.right == null) {
            // 已经走到最右边的 TreeNode
            return root.left;
        }
        root.right = removeMax(root.right);
        return root;

    }
}