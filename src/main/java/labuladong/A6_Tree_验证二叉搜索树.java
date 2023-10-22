/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A6_Tree_��֤����������.java, v 0.1 2023��10��21�� 14:28  Baojiang Yang Exp $
 */
public class A6_Tree_��֤���������� {

    /**
     * leeCode 98
     * ��֤����������
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /** �ж�һ��һrootΪ����BST��ֵ�Ƿ���min��max֮��
     * min��max����int����Ϊ��Ҫ��ʼ����Integer.MAX��MIN,���������������ֵ��Ϊ�������´��벻����,����ʹ��TreeNode
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }

        // ������Ӧ����root��min֮��,������Ӧ����max��root֮��,�����������ֵ��root, ����������Сֵ��root
        return isValidBST(root.left, root, min) && isValidBST(root.left, max, root);

    }

}