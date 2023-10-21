/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A6_Tree_二叉搜索树的范围和.java, v 0.1 2023年10月21日 14:26  Baojiang Yang Exp $
 */
public class A6_Tree_二叉搜索树的范围和 {
    int sum = 0;

    /**
     * 二叉搜索树的范围和
     * 1.首先用普通的二叉树的遍历框架来实现
     * leeCode 938
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        traverse(root, low, high);
        return sum;
    }

    public void traverse(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        traverse(root.left, low, high);
        traverse(root.right, low, high);
    }

    /**
     * 虽然考虑优化,充分利用额BST的特性,量身定制一套算法
     * 1.BST左小右大,如果遍历到的节点x比low小,那么该节点以下的偈都肯定都不low小,无需遍历, high节点同理
     */

    public void traverse2(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        // 节点比low还小,则左边无需遍历,去右边找
        if (root.val < low) {
            traverse(root.right, low, high);
        }
        // 节点比high大,则右边无需遍历,去左边找
        else if (root.val > high) {
            traverse(root.left, low, high);
        }
        // 否则就落入[low, high]的区间内,正常累加
        else {
            sum += root.val;
            traverse(root.left, low, high);
            traverse(root.right, low, high);
        }
    }
}