/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version �޽�������: A6_Tree_�޽�������.java, v 0.1 2023��10��22�� 16:36  Baojiang Yang Exp $
 */
public class A6_Tree_�޼������� {

    /**
     * �޽�������, ����BST root,������[low,high],Ҫ���޼�BSTֵ�����������ڵ�BST
     * �����˼���ǳ��°Ѵ������ֽ�ɹ�ģС��������,Ȼ������������Ľ���Ƶ���ԭ����Ľ��,
     *
     * leeCode 669
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        // 1.��ǰ�ڵ��lowС,��������һ������lowС,����������,����ɾ��������
        // 2.ȥ��������,��Ϊ�������п���Ҳ�����Ϸ��ĵ�����,���Բ���ֱ�ӷ���,ҲҪʹ���õݹ鶨��,ȥ����ɾ������������Ľڵ�
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // ͬ��
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // �������غ����������
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}