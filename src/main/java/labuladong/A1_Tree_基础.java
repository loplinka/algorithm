/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

import java.util.LinkedList;

/**
 * @author Baojiang Yang
 * @version ���ı���: A1_Tree.java, v 0.1 2023��09��17�� 02:59  Baojiang Yang Exp $
 */
public class A1_Tree_���� {
    /**
    * ��������ǰ�����
    * @param root
    */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // �ȴ�ӡ��ǰ�ڵ��ֵ
        System.out.println(root.val);
        // �ٴ�ӡ������
        preOrder(root.left);
        // ����ӡ������
        preOrder(root.right);
    }

    /**
    * ���������������
    * @param root
    */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // �ȴ�ӡ������
        inOrder(root.left);
        // �ٴ�ӡ��ǰ�ڵ��ֵ
        System.out.println(root.val);
        // ����ӡ������
        inOrder(root.right);
    }

    /**
    * �������ĺ������
    * @param root
    */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // �ȴ�ӡ������
        postOrder(root.left);
        // �ٴ�ӡ������
        postOrder(root.right);
        // ����ӡ��ǰ�ڵ��ֵ
        System.out.println(root.val);
    }


    public static int depth = 0;
    public static int res = 0;

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
        depth ++;
        // ʹ��һ��res����������ֵ
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // ����ǰ-1,��ָ�뷵����һ��
        depth --;

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




    public static LinkedList<Integer> preOrder  = new LinkedList<>();
    public static LinkedList<Integer> inOrder   = new LinkedList<>();
    public static LinkedList<Integer> postOrder = new LinkedList<>();

    /**
     * ����������
     * @param root
     */
    public static void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }

        // ǰ���������λ��
        preOrder.add(root.val);
        traverse(root.left);
        // �����������λ��
        inOrder.add(root.val);
        // �����������λ��
        postOrder.add(root.val);

    }

}