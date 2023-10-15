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
 * @version 二叉树层序遍历: A2_Tree_层序遍历.java, v 0.1 2023年09月26日 17:33  Baojiang Yang Exp $
 */
public class A2_Tree_BFS_层序遍历法 {

    /**
     * 二叉树的层序遍历
     * 1.使用while+for循环配合Queue的使用,是层序遍历的基本套路
     * 2.使用链表和队列的addLast和addFirst方法,可以实现上下和左右的笛卡尔积遍历
     * 3.之前学的使用递归的方式遍历的方式就是DFS
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

        // while循环控制数高度,从上往下遍历
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = Lists.newLinkedList();
            // for循环搭配队列的size,控制横向遍历树的单层,从左往右
            for (int i = 0; i < size; i++) {
                // 因为使用了队列搭配size控制了每层节点数,所以不不会把下一层的节点遍历出来
                TreeNode curr = q.poll();
                level.addLast(curr.val);
                // 而遍历当前层的时候会会把下一层的所有节点放到队列后边,衔接了下一次循环
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
     * N叉树的层序遍历
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