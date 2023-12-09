/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_��ת������.java, v 0.1 2023��09��17�� 13:15  Baojiang Yang Exp $
 */
public class A1_Tree_��ת������ {

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // ǰ�����λ��
        // ������������
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        traverse(root.left);
        traverse(root.right);
        // �������λ��
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