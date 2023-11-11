/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

import base.ThreeNode;

/**
 * @author Baojiang Yang
 * @version : A5_Tree_���ڵ���Ҳ�ָ��.java, v 0.1 2023��11��10�� 00:28  Baojiang Yang Exp $
 */
public class A5_Tree_���ڵ���Ҳ�ָ�� {

    // ������
    ThreeNode connect(ThreeNode root) {
        if (root == null)
            return null;
        // �����������������������ڽڵ�
        traverse(root.left, root.right);
        return root;
    }

    // �������������
    void traverse(ThreeNode node1, ThreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** ǰ��λ�� ****/
        // ������������ڵ㴩����
        node1.next = node2;

        // ������ͬ���ڵ�������ӽڵ�
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // ���ӿ�Խ���ڵ�������ӽڵ�
        traverse(node1.right, node2.left);
    }

}