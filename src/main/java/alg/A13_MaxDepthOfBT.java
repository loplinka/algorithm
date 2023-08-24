package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author baojiang
 * @version ����������: MaxMinDepthOfBT.java, v 0.1 2022��10��04�� ����10:00 baojiang Exp $
 */
public class A13_MaxDepthOfBT {

    public static void main(String[] args) {
        System.out.println(maxDepthBfs(createBinTree()));
        System.out.println(maxDepthDfs(createBinTree()));

    }

    /**
     *     3
     *    / \
     *   9   20
     *      / \
     *     15 7
     *      \
     *      4
     * @return
     */
    public static TreeNode createBinTree() {
        TreeNode leaf7 = new TreeNode(7);
        TreeNode leaf4 = new TreeNode(4);

        TreeNode parent15 = new TreeNode(15, null, leaf4);

        TreeNode left9 = new TreeNode(9, null, null);
        TreeNode right20 = new TreeNode(20, parent15, leaf7);

        return new TreeNode(3, left9, right20);
    }

    /**
     * bfs�������
     * @param root
     * @return
     */
    public static int maxDepthBfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int level = 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        // ��ʼ����
        while (!queue.isEmpty()) {
            // ÿ��Ľڵ�����
            int currLevelNodeNum = queue.size();
            for (int i = 1; i <= currLevelNodeNum; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // ÿ��ѭ������,����+1
            level++;
        }

        return level;
    }

    /**
     * dfs�������
     * @param root
     * @return
     */
    public static int maxDepthDfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepthDfs(root.left);
            int rightHeight = maxDepthDfs(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}