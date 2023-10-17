/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A4_Tree_合并二叉树.java, v 0.1 2023年10月18日 00:33  Baojiang Yang Exp $
 */
public class A4_Tree_合并二叉树 {

    /**
     * leeCode 617
     * 1.递归的修改一个数据结构: 首先要有返回TreeNode,然后递归调用谁就要用谁去接收,也就是要递归的修改
     * 2.思考:
     *  能否在中序位置调用? 不能,因为这样就会出现重复修改,比如说在中序位置调用,那么就会重复修改左子树
     *  能否在后序位置调用? 不能,因为这样就会出现重复修改,比如说在后序位置调用,那么就会重复修改右子树
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // base case
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // 前序遍历位置
        root1.val += root2.val;
        // 递归左右子树
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        // 后序遍历位置
        return root1;
    }
}