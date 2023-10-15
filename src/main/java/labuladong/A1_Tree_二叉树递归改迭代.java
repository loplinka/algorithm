/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.Stack;

import base.TreeNode;

/**
 * ��ʵ���е����ĵݹ����岻��,�����������ݹ�����������˼ά,ֻ��Ϊ�˿����ջ��˼ά
 * @author Baojiang Yang
 * @version : A1_Tree_�������ݹ�ĵ���.java, v 0.1 2023��09��21�� 01:00  Baojiang Yang Exp $
 */
public class A1_Tree_�������ݹ�ĵ��� {

    Stack<TreeNode> stk = new Stack<>();

    /**
     * �������ĵݹ����
     *
     * @param root
     */
    public void traverse(TreeNode root) {
        // ǰ�����
        stk.push(root);
        traverse(root.left);
        // �������
        traverse(root.right);
        // �������
        stk.pop();
    }

    // **��д�����µ�������***

    /**
     * ������
     * @param root
     */
    public void traverse2(TreeNode root) {
        // ָ����һ�α༭����������ڵ�
        TreeNode visited = new TreeNode(-1);

        // ��ʼ����������
        pushLeftBranch(root);

        while (!stk.isEmpty()) {
            TreeNode p = stk.peek();
            // p������������������,����������û�б�������
            if ((p.left == null || p.left == visited) && p.right != visited) {
                /* �������λ��**/
                // ����������ջ
                pushLeftBranch(p.right);
            }
            // p������������������
            if (p.right == null || p.right == visited) {
                /* �������λ��**/
                // ��pΪ���������Ѿ���������,��ջ,����visitedָ��p
                visited = stk.pop();
            }
        }
    }

    /**
     * �����֦һߣ����
     * @param p
     */
    public void pushLeftBranch(TreeNode p) {
        while (p != null) {
            /* ǰ�����λ��**/
            stk.push(p);
            p = p.left;
        }
    }

}