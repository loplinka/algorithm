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
 * @version : A2_Tree_层序遍历.java, v 0.1 2023年09月25日 00:08  Baojiang Yang Exp $
 */
public class A2_Tree_层序遍历 {

    /**
     * BFS
     * 从上到下遍历,每层从做到右,层序遍历
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

        // 控制从树的上到下一层一层遍历
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            // 控制每层从左到右遍历,size是这一层的节点个数,不会超出这个范围
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.addFirst(curr.val);
                // 把下一层的节点加入队列
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // 添加到链表头部
            res.addFirst(level);
        }
        return res;
    }

    /**
     *
     * 从下到上遍历,每层从左到右,层序遍历
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
            // 遍历这一层的所有节点,size是这一层的节点个数,不会超出这个范围
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.addFirst(curr.val);
                // 把下一层的节点加入队列
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // 添加到尾部头部
            res.addLast(level);
        }
        return res;
    }

    /**
     * 同理,还可以从下到上遍历,到从右到左遍历,以此类推,主要就两层循环配合各层的链表addFirst和addLast
     * 总结:
     * 1.层序遍历,用while循环配合第一个链表addLast和addFirsts控制上下;
     * 2.嵌套循环内用for循环子链表配合addLast和addFirsts控制左右;
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