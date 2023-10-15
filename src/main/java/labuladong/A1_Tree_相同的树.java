/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_��ͬ����.java, v 0.1 2023��09��19�� 00:47  Baojiang Yang Exp $
 */
public class A1_Tree_��ͬ���� {

    /**
    * �ж��������Ƿ���ͬ
    * @param p
    * @param q
    * @return
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // ��Ϊ�յĻ�����Ȼ��ͬ
        if (p == null && q == null) {
            return true;
        }
        // һ��Ϊ�գ�һ���ǿգ���Ȼ��ͬ
        if (p == null || q == null) {
            return false;
        }
        // �������ǿգ��� val ��һ��Ҳ����
        if (p.val != q.val) {
            return false;
        }

        // p �� q �ñȵĶ�������
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}