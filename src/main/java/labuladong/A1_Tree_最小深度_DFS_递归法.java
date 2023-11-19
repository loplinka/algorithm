/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_��С���.java, v 0.1 2023��09��17�� 22:56  Baojiang Yang Exp $
 */
public class A1_Tree_��С���_DFS_�ݹ鷨 {

    /**
     * DFS ���: ������
     */
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    /**
     * ����������,�ݹ鷨
     * @param root
     */
    public static void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        // ǰ���������λ��
        System.out.println(root.val);
        traverse2(root.left);
        // �����������λ��
        System.out.println(root.val);
        traverse2(root.right);
        // �����������λ��
        System.out.println(root.val);

    }

    /**
     * �ݹ����DFS�㷨, ��BFS������ʱ�临�Ӷȶ�һ��,�ռ临�ӶȲ�һ��
     * 1.DFS(�ݹ鷨):    ʱ�临�Ӷȸ��Ӷ�һ��=O(n)��Ϊһ��Ҫȫ���ݹ�������ܵó�����, �ռ临��O(���߶�)
     * 2.BFS(���������): ʱ�临�Ӷȸ��Ӷ�������=O(n),ʵ���ϴ����<O(n),��ΪֻҪ������һ��Ҷ�ӽڵ�ͻ���ǰ����,�ռ临�Ӷ���O(2�Ĳ����η�)
     */

    static int depth = 0;
    static int res   = Integer.MAX_VALUE;

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return res;
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.left == null) {
            res = Math.min(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    /**
     * �����㷨���Ը�д��������ʽ,�����б������뵽������
     */
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth2(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth2(root.right), min_depth);
        }

        return min_depth + 1;
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
        // ��������
        TreeNode root = createBinTree();
        //  traverse(root);
        //  System.out.println(res);
         dfsWithLevelPrint(root);
//        List<List<Integer>> lists = dfsWithLevel(root);
//        System.out.println(lists);
    }

    /**
     * ��ӡÿһ��
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
     * ��¼ÿһ��
     */
    public static List<List<Integer>>  dfsWithLevel(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(res, root, 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        // ÿ�㿪ʼʱ�½�һ���б�
        if (res.size() == level) {
            res.add(new LinkedList<>());
        }
        res.get(level).add(root.val);
        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
    }

}