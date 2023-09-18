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

    /**
     * 1.�����������ݽṹ��Ȼ�ʹ��еݹ������
     * 2.��Ϊ��������ÿ���ڵ������������ǹ�ģ��С���ǽṹ����ͬ��������,���Կ����ù�ģ��С��ԭ�������Ƶ�ԭ������
     * 3.��������Ȼ�ʺ������ݹ�˼ά,���������һ�����ڵ�,����Ȼ��Ҫ�뵽���ܲ��ܰ�����������õ���ģ��С���ӽڵ���
     * ����·���͡������Ⱥ���ͬ��������,�������˼·
     * 4.Ҫ��ȷһ���ݹ麯���Ķ��岢�������������,��Ҫ�����ݹ�ϸ��!
     */

    public static LinkedList<Integer> preOrder  = new LinkedList<>();
    public static LinkedList<Integer> inOrder   = new LinkedList<>();
    public static LinkedList<Integer> postOrder = new LinkedList<>();

    /**
     * ����������,�ݹ鷨
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

    /**
     * ǰ�����������,���η�
     * 1.���ȶ���һ������,�������ܱ�����ǰ��Ľ��
     * 2.Ȼ��ֱ������������,�ѽ���ϲ�����,���յõ��������Ľ��
     * @param root
     */
    public static LinkedList<Integer> preOrderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        // ǰ���������λ��
        res.add(root.val);
        res.addAll(preOrderTraversal(root.left));
        res.addAll(preOrderTraversal(root.right));

        return res;
    }

}