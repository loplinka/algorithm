/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package exercise;

import base.TreeNode;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_ǰ�����.java, v 0.1 2023��10��30�� 00:47  Baojiang Yang Exp $
 */
public class A2_Tree_ǰ����� {

    List<Integer> res = Lists.newArrayList();

    List<Integer> preorder(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    /* �����������κ��ⲿ����,ʹ��һ���ݹ�ó���*/
    List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> res = Lists.newArrayList();

        if (root == null) {
            return res;
        }

        // ǰ������Ľ����root.val �ڵ�һ��
        res.add(root.val);
        // ���ú������壬���������������ǰ��������
        res.addAll(preorderTraverse(root.left));
        // ���ú������壬���������������ǰ��������
        res.addAll(preorderTraverse(root.right));

        return res;
    }
}