/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import base.MultiTreeNode;
import com.google.common.collect.Lists;

import base.TreeNode;

/**
 *
 * @author Baojiang Yang
 * @version �������������: A2_Tree_�������.java, v 0.1 2023��09��26�� 17:33  Baojiang Yang Exp $
 */
public class A2_Tree_BFS_��������� {

    /**
     * �������Ĳ������
     * 1.ʹ��while+forѭ�����Queue��ʹ��,�ǲ�������Ļ�����·
     * 2.ʹ������Ͷ��е�addLast��addFirst����,����ʵ�����º����ҵĵѿ���������
     * 3.֮ǰѧ��ʹ�õݹ�ķ�ʽ�����ķ�ʽ����DFS
     * @param root
     * @return
     */
    public List<List<Integer>> leverOrder(TreeNode root) {
        LinkedList<List<Integer>> res = Lists.newLinkedList();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // whileѭ���������߶�,�������±���
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = Lists.newLinkedList();
            // forѭ��������е�size,���ƺ���������ĵ���,��������
            for (int i = 0; i < size; i++) {
                // ��Ϊʹ���˶��д���size������ÿ��ڵ���,���Բ��������һ��Ľڵ��������
                TreeNode curr = q.poll();
                level.addLast(curr.val);
                // ��������ǰ���ʱ�������һ������нڵ�ŵ����к��,�ν�����һ��ѭ��
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            res.addLast(level);
        }

        return res;
    }

    /**
     * N�����Ĳ������
     *
     */
    public List<List<Integer>> levelOrder(MultiTreeNode root) {

        List<List<Integer>> res = Lists.newLinkedList();
        if (root == null) {
            return res;
        }

        Queue<MultiTreeNode> q = Lists.newLinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> level = Lists.newLinkedList();
            for (int i = 0; i < sz; i++) {
                MultiTreeNode curr = q.poll();
                level.add(curr.val);
                for (MultiTreeNode child : curr.childrens) {
                    q.offer(child);
                }
            }
            res.add(level);
        }

        return res;
    }
}