/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

import java.util.Stack;

/**
 *
 * leecode 173
 *
 * ʵ��һ��next����,����ʱ�򷵻�һ���������(����)���
 * 1.�������˼·:�����������������Ľ��������,Ȼ��next����ÿ�η���һ��Ԫ��,ȱ����ռ���ڴ�
 * 2.���ǵ�����Ҫ���Ƕ��Ե�,Ҫ���õ�ʱ��ż��㷵��
 *
 * @author Baojiang Yang
 * @version : A6_Tree_����������������.java, v 0.1 2023��10��22�� 17:13  Baojiang Yang Exp $
 */
public class A6_Tree_���������������� {

    Stack<TreeNode> stk = new Stack<>();

    // �����֦һߣ����
    private void pushLeftBranch(TreeNode p) {
        while (p != null) {
            stk.push(p);
            p = p.left;
        }
    }

    // ����
    public A6_Tree_����������������(TreeNode root) {
        pushLeftBranch(root);
    }

    public int next() {
        TreeNode p = stk.pop();
        pushLeftBranch(p.right);
        return p.val;
    }

    public boolean hasNext() {
        return !stk.isEmpty();
    }

}