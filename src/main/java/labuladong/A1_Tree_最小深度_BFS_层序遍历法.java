/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import base.TreeNode;

/**
 * 使用层序遍历法
 * @author Baojiang Yang
 * @version : A1_Tree_最小深度.java, v 0.1 2023年09月17日 22:56  Baojiang Yang Exp $
 */
public class A1_Tree_最小深度_BFS_层序遍历法 {

    /**
     * BFS框架
     */
    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

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

    public static void main(String[] args) {
        // 测试用例
        TreeNode root = createBinTree();
        // traverse(root);
        // System.out.println(res);
        // dfsWithLevelPrint(root);
//        List<List<Integer>> lists = dfsWithLevel(root);
//        System.out.println(lists);

        dfsItePrint(root);

    }

    /**
     * 打印每一层
     * @param root
     */
    public static void dfsWithLevelPrint(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        queue.offer(root);
        levelQueue.offer(0);

        int curLevel = 0;
        System.out.print("Level " + curLevel + ": ");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = levelQueue.poll();

            if (level != curLevel) {
                curLevel = level;
                System.out.println();
                System.out.print("Level " + curLevel + ": ");
            }

            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
                levelQueue.offer(level + 1);
            }

            if (node.right != null) {
                queue.offer(node.right);
                levelQueue.offer(level + 1);
            }
        }
    }

    /**
     * 记录每一层,迭代法
     */
    public static List<List<Integer>> dfsWithLevel(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfsRec(res, root, 0);
        return res;
    }

    private static void dfsRec(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        // 每层开始时新建一个列表
        if (res.size() == level) {
            res.add(new LinkedList<>());
        }
        res.get(level).add(root.val);
        dfsRec(res, root.left, level + 1);
        dfsRec(res, root.right, level + 1);
    }

    public static void dfsItePrint(TreeNode root) {
        List<List<Integer>> lists = dfsIte(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }

    /**
     * 记录没一层,递归法
     */
    public static List<List<Integer>> dfsIte(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(levelList);
        }
        return res;
    }

}