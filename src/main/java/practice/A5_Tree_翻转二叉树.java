/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A5_Tree_����ƪ.java, v 0.1 2023��11��09�� 22:51  Baojiang Yang Exp $
 */
public class A5_Tree_��ת������ {

    /**
     * ��ת������
     * leecode 226
     * ���ѷ��֣�ֻҪ�Ѷ������ϵ�ÿһ���ڵ�������ӽڵ���н��������Ľ��������ȫ��ת֮��Ķ�������
     */

    /**
     *  1�������ܲ����á���������˼άģʽ�����
     * ���ԣ���дһ�� traverse ��������ÿ���ڵ㣬��ÿ���ڵ�������ӽڵ�ߵ����������ˡ�
     * �������һ���ڵ㣬��Ҫ������ʲô���������Լ��������ӽڵ㽻��һ�¡�
     * ��Ҫ��ʲôʱ����������ǰ�к���λ�ö���T�ԡ�
     * ���ϣ�����д�����½ⷨ���룺
     */
    TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // ÿһ���ڵ���Ҫ�����¾��ǽ������������ӽڵ�
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // ������ܣ�ȥ�������������Ľڵ�
        traverse(root.left);
        traverse(root.right);

    }

    /**
     * 2�������ܲ����á��ֽ����⡹��˼άģʽ�����
     *
     * ���ǳ��Ը� invertTree ��������һ�����壺
     *
     * // ���壺���� root Ϊ������ö�������ת�����ط�ת��Ķ������ĸ��ڵ�
     * TreeNode invertTree(TreeNode root);
     *
     */

    TreeNode revertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // ���ú������壬�ȷ�ת��������
        TreeNode left = revertTree(root.left);
        TreeNode right = revertTree(root.right);

        // Ȼ�󽻻������ӽڵ�
        root.left = right;
        root.right = left;

        // �Ͷ����߼���ǡ���� root Ϊ������ö������Ѿ�����ת������ root
        return root;
    }

    /**
     * ���֡��ֽ����⡹��˼·������������Ҫ���ݹ麯��һ�����ʵĶ��壬Ȼ���ú����Ķ�����������Ĵ��룻�������߼��ɹ���ǡ����ô˵��������㷨����ȷ�ġ�
     * ���ˣ������ͷ������⣬���������͡��ֽ����⡹��˼·�����Խ��
     *
     */

}