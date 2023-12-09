/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.Stack;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_��С���.java, v 0.1 2023��09��17�� 22:56  Baojiang Yang Exp $
 */
public class A1_Tree_��С���_DFS_�ݹ鷨 {

    /**
     * DFS ���: ������
     */
    public static void dfs(TreeNode root) {
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
        //traverse(root);
        dfs(root);
    }


    public void dfsRes(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            int sz = stack.size();
            for (int i = 0; i < sz; i++) {
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
    }

    public int minDepthMS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        traverse3MS(root);
        return res;
    }

    private void traverse3MS(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            res = Math.min(res, depth);
        }
        traverse3MS(root.left);
        traverse3MS(root.left);
        depth--;
    }
    
    
    public int minDepResMS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepResMS(root.left), min_depth);
        }

        if (root.right != null) {
            min_depth = Math.min(minDepResMS(root.right), min_depth);
        }
        return min_depth + 1;
    }


}