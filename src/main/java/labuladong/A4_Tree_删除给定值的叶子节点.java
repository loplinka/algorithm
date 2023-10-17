/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A3_Tree_删除给定值的叶子节点.java, v 0.1 2023年10月18日 00:20  Baojiang Yang Exp $
 */
public class A4_Tree_删除给定值的叶子节点 {

    /**
     * leeCode 1325
     * 思考
     * 1.当前节点应该要做什么事情(题目要求); 在什么时候做(前中后序遍历)
     * 2.前序遍历:即将进入这个节点的位置; 后续遍历:即将离开这个节点的位置;
     * 3.所以只有后序遍历,即将离开节点时才能判断自己是否是叶子节点,从而接手这个null
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        // 后序遍历位置 判断是否是叶子节点
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}