/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package exercise;

import base.ListNode;
import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_�������.java, v 0.1 2023��10��29�� 18:16  Baojiang Yang Exp $
 */
public class A1_Tree_������� {

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // ǰ�����
        traverse(root.left);
        // �������
        traverse(root.right);
        // �������
    }

    /* ������������ */
    void traverse2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // ��������arr[i]
        }
    }

    /* �ݹ�������� */
    void traverse3(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        traverse3(arr, i + 1);
    }

    /*�������ʵ�����*/
    void traverse4(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {

        }

    }


    /*�ݹ���ʵ�����*/
    void traverse5(ListNode head) {
        if (head == null) {
            return;
        }

        traverse5(head.next);
    }


    /*�����Ӧ������������ֵ*/
     void traverse6(ListNode head) {
         if (head == null) {
             return;
         }
         traverse6(head.next);
         // ��������λ�ô�ӡ
         System.out.println(head.val);

     }


    /**
     * �������ݹ����㷨������˼·:
     * 1.����һ����ܶ������ó���,��Ӧ:�����㷨���(Backtrace),û�з���ֵ
     * 2.ͨ���ֽ�������õ�ԭ����Ĵ�,��Ӧ:��̬�滮���(Dynamic Programming) �з���ֵ,������ԣ�д������ݹ麯���Ķ��壬�����������������ķ���ֵ��
     * 3.����ʹ����һ��˼άģʽ���㶼Ҫ���׶�������ÿһ���ڵ���Ҫ��ʲô����Ҫ��ʲôʱ��ǰ�к�����
     *
     * ǰ��λ�õĴ���ִ�����Զ����µģ�������λ�õĴ���ִ�����Ե����ϵģ�
     *
     * ǰ��λ���Ǹոս���ڵ��ʱ�̣�����λ���Ǽ����뿪�ڵ��ʱ�̡�
     *
     * ����������������ζ��ǰ��λ�õĴ���ֻ�ܴӺ��������л�ȡ���ڵ㴫���������ݣ�������λ�õĴ��벻�����Ի�ȡ�������ݣ������Ի�ȡ������ͨ����������ֵ���ݻ��������ݡ�
     *
     */





}