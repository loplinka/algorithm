/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 *
 * @author Baojiang Yang
 * @version : A2_Tree_�������Ļ����������.java, v 0.1 2023��09��26�� 18:42  Baojiang Yang Exp $
 */
public class A1_Tree_�������Ļ���������� {

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // ǰ�����λ��

        traverse(root.left);
        // �������λ��

        traverse(root.right);

        // ��������λ��
    }
}