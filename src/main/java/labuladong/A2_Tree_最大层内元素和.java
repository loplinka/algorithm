/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.LinkedList;
import java.util.Queue;

import com.google.common.collect.Lists;

import base.TreeNode;

/**
 * ��ÿһ��Ľڵ�ֵ���,���غ�����һ��
 * @author Baojiang Yang
 * @version : A2_Tree_������Ԫ�غ�.java, v 0.1 2023��09��26�� 18:53  Baojiang Yang Exp $
 */
public class A2_Tree_������Ԫ�غ� {

    /**
     * ������Ԫ�غ�
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = Lists.newLinkedList();
        q.offer(root);
        // ���: �������Ĳ���
        int depth = 1;
        // �Ƚ����ֵ����
        int maxSum = Integer.MIN_VALUE;
        // ����ָ��
        int index = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                // forѭ��������ǰ��ڵ�ֵ��
                levelSum += curr.val;
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // forѭ������,�õ�ǰ��ͼ�¼�����ֵ�Ƚ�,�ȼ�¼ֵ��͸���һ��,ͬʱ��¼��ǰ����
            if (levelSum > maxSum) {
                maxSum = levelSum;
                index = depth;
            }
            depth++;
        }

        return index;
    }


    public int maxLevelSumMSS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // ���
        int depth = 1;
        // �����
        int maxSum = Integer.MIN_VALUE;
        // ����ָ��
        int index = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            int levelSum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                levelSum = levelSum + node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            // �Ƚ����ֵ
            if (levelSum > maxSum) {
                maxSum = levelSum;
                index = depth;
            }
            depth++;
        }

        return index;
    }

}