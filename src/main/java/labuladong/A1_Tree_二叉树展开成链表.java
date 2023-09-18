/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_二叉树展开成链表.java, v 0.1 2023年09月19日 00:52  Baojiang Yang Exp $
 */
public class A1_Tree_二叉树展开成链表 {

        /**
        * 把一棵树拉平成一条链表
        * @param root
        */
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            // 左子树已经被拉平成一条链表
            flatten(root.left);
            TreeNode left = root.left;
            // 右子树已经被拉平成一条链表
            flatten(root.right);
            TreeNode right = root.right;

            // 2.将左子树作为右子树
            root.left = null;
            root.right = left;

            // 3.将原先的右子树接到当前右子树的末端
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;

        }
}