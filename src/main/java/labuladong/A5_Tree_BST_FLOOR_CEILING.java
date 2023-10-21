/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A5_Tree_BST_FLOOR_CEILING.java, v 0.1 2023��10��21�� 10:50  Baojiang Yang Exp $
 */
public class A5_Tree_BST_FLOOR_CEILING {

    /**
     * ����leeCode 700 SBT������
     * ���Ŀ��ֵ������,���ر�Ŀ��ֵ�����С��key,���߱�Ŀ��ֵС������key
     */

    public TreeNode searchBSTFloor(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (root.val < val) {
            // ��������ȥ��, ��һ�����ַ���Ϊ�յ�,���Լ����ػ�ȥ,�����Ϳ���һ·���յ����ֵfloor key
            TreeNode x = searchBSTFloor(root.right, val);
            if (x == null) {
                return root;
            }
            return x;
        } else {
            // ��������ȥ��
            return searchBSTFloor(root.left, val);

        }
    }

    public TreeNode searchBSTCeiling(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (root.val < val) {
            // ��������ȥ��,
            return searchBSTCeiling(root.right, val);

        } else {
            // ��������ȥ��, ��һ�����ַ���Ϊ�յ�,���Լ����ػ�ȥ,�����Ϳ���һ·���յ����ֵcelling key
            TreeNode x = searchBSTCeiling(root.left, val);
            if (x == null) {
                return root;
            }
            return x;

        }
    }
}