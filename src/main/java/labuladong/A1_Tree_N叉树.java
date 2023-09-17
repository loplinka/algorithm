/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.LinkedList;
import java.util.List;

import base.MultiTreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_N����.java, v 0.1 2023��09��18�� 00:31  Baojiang Yang Exp $
 */
public class A1_Tree_N���� {

    List<Integer> res = new LinkedList<>();

    public List<Integer> preorder(MultiTreeNode root) {
        traverse(root);
        return res;
    }

    /**
     * N�����ı���,��סû���������
     * @param root
     */
    public void traverse(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        // ǰ�����
        res.add(root.val);
        for (MultiTreeNode child : root.childrens) {
            traverse(child);
        }
        // �������
    }

    /**
     * �����ǰ��ͺ�������ŵ�forѭ����,����ֻ���������ڵ�,��Ч���Ͳ�����֮ǰ��һ����
     * @param root
     */
    public void traverse2(MultiTreeNode root) {
        if (root == null) {
            return;
        }

        for (MultiTreeNode child : root.childrens) {
            // ǰ�����
            res.add(child.val);
            traverse2(child);
            // �������
        }

    }
}