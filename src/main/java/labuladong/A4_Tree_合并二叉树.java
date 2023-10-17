/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A4_Tree_�ϲ�������.java, v 0.1 2023��10��18�� 00:33  Baojiang Yang Exp $
 */
public class A4_Tree_�ϲ������� {

    /**
     * leeCode 617
     * 1.�ݹ���޸�һ�����ݽṹ: ����Ҫ�з���TreeNode,Ȼ��ݹ����˭��Ҫ��˭ȥ����,Ҳ����Ҫ�ݹ���޸�
     * 2.˼��:
     *  �ܷ�������λ�õ���? ����,��Ϊ�����ͻ�����ظ��޸�,����˵������λ�õ���,��ô�ͻ��ظ��޸�������
     *  �ܷ��ں���λ�õ���? ����,��Ϊ�����ͻ�����ظ��޸�,����˵�ں���λ�õ���,��ô�ͻ��ظ��޸�������
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // base case
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // ǰ�����λ��
        root1.val += root2.val;
        // �ݹ���������
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        // �������λ��
        return root1;
    }
}