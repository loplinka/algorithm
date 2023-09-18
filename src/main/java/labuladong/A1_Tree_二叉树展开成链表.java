/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_������չ��������.java, v 0.1 2023��09��19�� 00:52  Baojiang Yang Exp $
 */
public class A1_Tree_������չ�������� {

        /**
        * ��һ������ƽ��һ������
        * @param root
        */
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            // �������Ѿ�����ƽ��һ������
            flatten(root.left);
            TreeNode left = root.left;
            // �������Ѿ�����ƽ��һ������
            flatten(root.right);
            TreeNode right = root.right;

            // 2.����������Ϊ������
            root.left = null;
            root.right = left;

            // 3.��ԭ�ȵ��������ӵ���ǰ��������ĩ��
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;

        }
}