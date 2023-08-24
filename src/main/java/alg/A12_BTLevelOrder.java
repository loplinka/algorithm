package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import base.TreeNode;
import tools.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author baojiang
 * @version ��������α���: alg.A12_BTLevelOrder.java, v 0.1 2022��10��04�� ����8:30 baojiang Exp $
 */
public class A12_BTLevelOrder {

    public static void main(String[] args) {
        PrintUtil.printList(levelOrder(createBinTree()));
    }

    /**
     *     3
     *    / \
     *   9   20
     *  /   / \
     * 21  15 7
     *
     * @return
     */
    public static TreeNode createBinTree() {
        TreeNode leaf21 = new TreeNode(21);
        TreeNode leaf15 = new TreeNode(15);
        TreeNode leaf7 = new TreeNode(7);

        TreeNode left9 = new TreeNode(9, leaf21, null);
        TreeNode right20 = new TreeNode(20, leaf15, leaf7);

        return new TreeNode(3, left9, right20);
    }

    /**
     * bfs����
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // ����
            List<Integer> level = new ArrayList<Integer>();
            // queue.size����ÿ�����Ľڵ�����
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                // ��������
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    /**
     * ������ȱ����㷨�ο�(������) Breadth First Search
     * @param root
     * @return
     */
    public static List<Integer> bfs(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (result.contains(head.val)) {
                throw new RuntimeException("�����ظ��ڵ�����л�!");
            }
            result.add(head.val);
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
        }

        return result;
    }
}