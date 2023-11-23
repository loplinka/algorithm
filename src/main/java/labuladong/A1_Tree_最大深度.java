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
     *  �˷����Ƕ�̬�滮(����Ǯ)������: ���ҹ�ģ��С,�ṹ��ͬ������,Ҳ�Ƿ��ε�˼·
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

    /**
     *     3
     *    / \
     *   9   20
     *      / \
     *     15 7
     *      \
     *      4
     * @return
     */
    public static TreeNode createBinTree() {
        TreeNode leaf7 = new TreeNode(7);
        TreeNode leaf4 = new TreeNode(4);

        TreeNode parent15 = new TreeNode(15, null, leaf4);

        TreeNode left9 = new TreeNode(9, null, null);
        TreeNode right20 = new TreeNode(20, parent15, leaf7);

        return new TreeNode(3, left9, right20);
    }

    public static void main(String[] args) {
        // ��������
        TreeNode root = createBinTree();
        traverse(root);
        System.out.println(res);
    }
}