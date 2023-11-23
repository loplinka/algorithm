/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_路径和_分治法.java, v 0.1 2023年09月18日 01:24  Baojiang Yang Exp $
 */
public class A1_Tree_路径和_分治法 {

    /**
     * leeCode 112. 路径总和
    * 二叉树中路径和等于target的路径数量
    * @param root
    * @param target
    * @return
    */
    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // 叶子节点,target一直往下减去遍历过的节点后,判断叶子节点是否等于剩下最后的target,等于就赋值返回结束当前递归
        if (root.left == null && root.right == null && root.val == target) {
            return true;
        }

        // 问题分解成在左子树和右子树中找target - root.val 或者在右子树中找target - root.val,任何一个满足条件即可
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
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