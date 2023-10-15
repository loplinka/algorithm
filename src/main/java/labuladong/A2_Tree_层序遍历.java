/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Baojiang Yang
 * @version : A2_Tree_�������.java, v 0.1 2023��09��25�� 00:08  Baojiang Yang Exp $
 */
public class A2_Tree_������� {

    /**
     * BFS
     * ���ϵ��±���,ÿ���������,�������
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // ���ƴ������ϵ���һ��һ�����
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            // ����ÿ������ұ���,size����һ��Ľڵ����,���ᳬ�������Χ
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.addFirst(curr.val);
                // ����һ��Ľڵ�������
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // ��ӵ�����ͷ��
            res.addFirst(level);
        }
        return res;
    }

    /**
     *
     * ���µ��ϱ���,ÿ�������,�������
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            // ������һ������нڵ�,size����һ��Ľڵ����,���ᳬ�������Χ
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.addFirst(curr.val);
                // ����һ��Ľڵ�������
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // ��ӵ�β��ͷ��
            res.addLast(level);
        }
        return res;
    }

    /**
     * ͬ��,�����Դ��µ��ϱ���,�����ҵ������,�Դ�����,��Ҫ������ѭ����ϸ��������addFirst��addLast
     * �ܽ�:
     * 1.�������,��whileѭ����ϵ�һ������addLast��addFirsts��������;
     * 2.Ƕ��ѭ������forѭ�����������addLast��addFirsts��������;
     *
     * @param args
     */

    public static void main(String[] args) {

        LinkedList<Integer> level = new LinkedList<>();
        level.addFirst(1);
        level.addFirst(2);
        level.addFirst(3);
        level.addLast(4);
        System.out.println(

        );

    }
}