/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A6_Tree_�����������ķ�Χ��.java, v 0.1 2023��10��21�� 14:26  Baojiang Yang Exp $
 */
public class A6_Tree_�����������ķ�Χ�� {
    int sum = 0;

    /**
     * �����������ķ�Χ��
     * 1.��������ͨ�Ķ������ı��������ʵ��
     * leeCode 938
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        traverse(root, low, high);
        return sum;
    }

    public void traverse(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        traverse(root.left, low, high);
        traverse(root.right, low, high);
    }

    /**
     * ��Ȼ�����Ż�,������ö�BST������,������һ���㷨
     * 1.BST��С�Ҵ�,����������Ľڵ�x��lowС,��ô�ýڵ����µ��ʶ��϶�����lowС,�������, high�ڵ�ͬ��
     */

    public void traverse2(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        // �ڵ��low��С,������������,ȥ�ұ���
        if (root.val < low) {
            traverse(root.right, low, high);
        }
        // �ڵ��high��,���ұ��������,ȥ�����
        else if (root.val > high) {
            traverse(root.left, low, high);
        }
        // ���������[low, high]��������,�����ۼ�
        else {
            sum += root.val;
            traverse(root.left, low, high);
            traverse(root.right, low, high);
        }
    }
}