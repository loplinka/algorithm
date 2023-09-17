/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version ·����: A1_Tree_·����.java, v 0.1 2023��09��17�� 12:42  Baojiang Yang Exp $
 */
public class A1_Tree_·����_���ݷ� {

    static boolean found  = false;
    static int     curSum = 0;
    static int     target = 0;

    /**
     * �Ƿ���ں�targetSum��ȵ�·����
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        target = targetSum;
        traverse(root);
        return found;
    }

    /**
     * ����
     * @param root
     */
    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // ǰ�����λ��
        curSum += root.val;
        // �Ƿ���Ҷ�ӽڵ�
        if (root.left == null && root.left == null) {
            if (target == curSum) {
                found = true;
            }
        }
        traverse(root.left);
        traverse(root.right);
        // �������λ��
        curSum -= root.val;
    }

    public static void main(String[] args) {

    }

}