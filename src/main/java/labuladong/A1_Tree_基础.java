/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.LinkedList;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version ���ı���: A1_Tree.java, v 0.1 2023��09��17�� 02:59  Baojiang Yang Exp $
 */
public class A1_Tree_���� {

    public static LinkedList<Integer> preOrder  = new LinkedList<>();
    public static LinkedList<Integer> inOrder   = new LinkedList<>();
    public static LinkedList<Integer> postOrder = new LinkedList<>();

    /**
     * ����������
     * @param root
     */
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // ǰ���������λ��
        preOrder.add(root.val);
        traverse(root.left);
        // �����������λ��
        inOrder.add(root.val);
        traverse(root.right);
        // �����������λ��
        postOrder.add(root.val);

    }

    public static void main(String[] args) {
        // ��������

    }

}