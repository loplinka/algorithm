/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 *
 * @author Baojiang Yang
 * @version : A2_Tree_DFS_�ݹ鷨.java, v 0.1 2023��09��26�� 18:22  Baojiang Yang Exp $
 */
public class A2_Tree_������_DFS_�ݹ鷨 {

    int depth = 0;
    int res   = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return depth;
        }
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // ǰ�����λ��: ����֮ǰ��ѡ��
        depth++;
        // ����Ҷ�ӽڵ�,�űȽ���Сֱ
        if (root.left == null && root.right == null) {
            res = Math.max(depth, res);
        }
        traverse(root.left);
        traverse(root.right);
        // ��������λ��: �˳�����ѡ��
        depth--;
    }

    /** �����Ļ���д��,�������ݹ�,���԰������������ⲿ��Աд��������� */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = maxDepth2(root.left);
        int maxRight = maxDepth2(root.right);
        return 1 + Math.max(maxLeft, maxRight);
    }

}