/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package la;

import java.util.Queue;

import com.google.common.collect.Lists;

import base.TreeNode;

/**
 *
 * @author Baojiang Yang
 * @version : A2_Tree_��С���_���������.java, v 0.1 2023��09��26�� 17:57  Baojiang Yang Exp $
 */
public class A2_Tree_��С���_��������� {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = Lists.newLinkedList();
        q.offer(root);

        // root�������һ��,��ȳ�ʼ��Ϊ1
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                // �ж��Ƿ�ﵽ�յ�
                if (curr.left == null && curr.right ==null) {
                    return depth;
                }
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