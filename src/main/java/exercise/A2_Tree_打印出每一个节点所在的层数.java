/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package exercise;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A2_Tree_��ӡ��ÿһ���ڵ����ڵĲ���.java, v 0.1 2023��10��30�� 01:02  Baojiang Yang Exp $
 */
public class A2_Tree_��ӡ��ÿһ���ڵ����ڵĲ��� {

    void level(TreeNode root) {
        traverse(root, 1);
    }

    private void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        System.out.println("�ڵ� %s �ڵ� %d ��" + root + level);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);

    }
}