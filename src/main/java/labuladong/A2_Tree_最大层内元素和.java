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
 * 把每一层的节点值相加,返回和最大的一层
 * @author Baojiang Yang
 * @version : A2_Tree_最大层内元素和.java, v 0.1 2023年09月26日 18:53  Baojiang Yang Exp $
 */
public class A2_Tree_最大层内元素和 {

    /**
     * 最大层内元素和
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = Lists.newLinkedList();
        q.offer(root);
        // 深度: 遍历到的层数
        int depth = 1;
        // 比较最大值变量
        int maxSum = Integer.MIN_VALUE;
        // 层数指针
        int index = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                // for循环结束当前层节点值和
                levelSum += curr.val;
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // for循环结束,拿当前层和记录的最大值比较,比记录值大就更新一下,同时记录当前层数
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

        // 深度
        int depth = 1;
        // 最大是
        int maxSum = Integer.MIN_VALUE;
        // 层数指针
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

            // 比较最大值
            if (levelSum > maxSum) {
                maxSum = levelSum;
                index = depth;
            }
            depth++;
        }

        return index;
    }

}