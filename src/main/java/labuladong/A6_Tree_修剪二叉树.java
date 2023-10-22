/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version 修建二叉树: A6_Tree_修建二叉树.java, v 0.1 2023年10月22日 16:36  Baojiang Yang Exp $
 */
public class A6_Tree_修剪二叉树 {

    /**
     * 修建二叉树, 给定BST root,和区间[low,high],要求修剪BST值保留在区间内的BST
     * 该提的思想是常事把大的问题分解成规模小的子问题,然后利用子问题的结果推导出原问题的结果,
     *
     * leeCode 669
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        // 1.当前节点比low小,则左子树一定都比low小,返回右子树,就是删除左子树
        // 2.去右子树找,因为右子树中可能也包不合法的的数据,所以不能直接返回,也要使用用递归定义,去遍历删除符合区间外的节点
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // 同理
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // 上述返回后由这里接收
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}