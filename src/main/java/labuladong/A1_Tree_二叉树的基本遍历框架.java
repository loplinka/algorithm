/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 *
 * @author Baojiang Yang
 * @version : A2_Tree_二叉树的基本遍历框架.java, v 0.1 2023年09月26日 18:42  Baojiang Yang Exp $
 */
public class A1_Tree_二叉树的基本遍历框架 {

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置

        traverse(root.left);
        // 中序遍历位置

        traverse(root.right);

        // 后续遍历位置
    }
}