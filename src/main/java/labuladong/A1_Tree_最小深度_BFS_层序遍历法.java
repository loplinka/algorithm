/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.LinkedList;
import java.util.Queue;

import base.TreeNode;

/**
 * 使用层序遍历法
 * @author Baojiang Yang
 * @version : A1_Tree_最小深度.java, v 0.1 2023年09月17日 22:56  Baojiang Yang Exp $
 */
public class A1_Tree_最小深度_BFS_层序遍历法 {

    /**
     * 层序遍历,广度优先解法
     * @param root
     * @return
     */
    public Integer minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root本身就是一层,初始化为1
        int depth = 1;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            for (int i = 0; i < q.size(); i++) {
                // 判断是否到达终点
                if (curr.right == null && curr.left == null) {
                    return depth;
                }
                // 左右两边加入队列
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