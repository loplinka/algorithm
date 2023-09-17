/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_������.java, v 0.1 2023��09��17�� 22:53  Baojiang Yang Exp $
 */
public class A1_Tree_������ {
    public static int depth = 0;
    public static int res   = 0;

    /**
     * ��������������
     * �����ʽ�ǻ����㷨������(N�ʺ�����)
     * @param root
     */
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // ��֮ǰ��1,��ָ�����������һ��
        depth++;
        // ʹ��һ��res����������ֵ
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // ����ǰ-1,��ָ�뷵����һ��
        depth--;

    }

    /**
     * ��������������
     *  �ⷨ��: �ֱ�������������������,Ȼ��ȡ��,����1���ڵ�,��Ϊ������
     *  �η����Ƕ�̬�滮(����Ǯ)������: ���ҹ�ģ��С,�ṹ��ͬ������,Ҳ�Ƿ��ε�˼·
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
}