/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.LinkedList;
import java.util.Queue;

import base.TreeNode;

/**
 * ʹ�ò��������
 * @author Baojiang Yang
 * @version : A1_Tree_��С���.java, v 0.1 2023��09��17�� 22:56  Baojiang Yang Exp $
 */
public class A1_Tree_��С���_BFS_��������� {

    /**
     * �������,������Ƚⷨ
     * @param root
     * @return
     */
    public Integer minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root�������һ��,��ʼ��Ϊ1
        int depth = 1;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            for (int i = 0; i < q.size(); i++) {
                // �ж��Ƿ񵽴��յ�
                if (curr.right == null && curr.left == null) {
                    return depth;
                }
                // �������߼������
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }

}