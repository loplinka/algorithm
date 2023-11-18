package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import base.QueueNode;
import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author baojiang
 * @version 最小深度: alg.A14_MinDepthOfBT.java, v 0.1 2022年10月04日 下午11:20 baojiang Exp $
 */
public class A14_MinDepthOfBT {

    public static void main(String[] args) {
        System.out.println(minDepthBfs(createBinTree()));
        System.out.println(minDepthDfs(createBinTree()));

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

    public static int minDepthDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepthDfs(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepthDfs(root.right), min_depth);
        }

        return min_depth + 1;
    }

    public static int minDepthBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }

}