/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version �����������Ļ�������: A5_Tree_����������_��������.java, v 0.1 2023��10��19�� 00:55  Baojiang Yang Exp $
 */
public class A5_Tree_����������_�������� {

    /**
     * leeCode 700
     * �����������е�����
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
            // ��������ȥ��
            return searchBST(root.right, val);
        } else {
            // ��������ȥ��
            return searchBST(root.left, val);
        }
    }

    /**
     * leeCode 701
     * BST�Ĳ���
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // ���������root�ǿյ�,��˵����Ԥ�ڵ�λ��,����һ���µĽڵ�,��һ��ָ������
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            // ��������ȥ��
            root.right = insertIntoBST(root.right, val);
        } else {
            // ��������ȥ��
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public TreeNode deleteTreeNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            // ���1, Key��root��val����
            root.right = deleteTreeNode(root.right, key);
        } else if (root.val > key) {
            // ���2, Key��root��val��С
            root.left = deleteTreeNode(root.left, key);
        } else {
            // ���3, Key����root��val
            if (root.left == null) {
                // ���3.1, ������Ϊ��,ֱ�ӷ���������
                return root.right;
            }
            if (root.right == null) {
                // ���3.2, ������Ϊ��,ֱ�ӷ���������
                return root.left;
            }
            // ���3.3, ������������Ϊ��,�ҵ������������Ľڵ�,�滻����ǰ�ڵ�
            TreeNode leftMax = maxNode(root.left);
            // ɾ������������С�Ľڵ�
            root.right = removeMax(root.left);
            leftMax.left = root.left;
            leftMax.right = root.right;
            root = leftMax;

        }
        return root;
    }

    /**
     * BST�в������ڵ�
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
     * ɾ����rootΪ����BST�����Ľڵ�
     * @param root
     * @return
     */
    public TreeNode removeMax(TreeNode root) {
        if (root.right == null) {
            // �Ѿ��ߵ����ұߵ� TreeNode
            return root.left;
        }
        root.right = removeMax(root.right);
        return root;

    }
}