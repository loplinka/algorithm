package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import base.TreeNode;
import tools.PrintUtil;

import java.util.*;

/**
 *
 * @author baojiang
 * @version 二叉树的各种遍历方式: alg.A7_TreeSearch.java, v 0.1 2022年10月03日 下午6:16 baojiang Exp $
 */
public class A7_TreeSearch {

    public static void main(String[] args) {

        System.out.println("广度:");
        PrintUtil.print(bfs(createBinTree()));
        System.out.println("深度:");
        PrintUtil.print(dfs(createBinTree()));
        PrintUtil.print(dfsByR(createBinTree()));

        System.out.println("前序:");
        PrintUtil.print(PreOrder.preOrder(createBinTree()));
        PrintUtil.print(PreOrder.preOrderByR(createBinTree()));

        System.out.println("中序:");
        PrintUtil.print(InOrder.inOrder(createBinTree()));
        PrintUtil.print(InOrder.inOrderByR(createBinTree()));

        System.out.println("后序:");
        PrintUtil.print(PostOrder.postOrder(createBinTree()));
        PrintUtil.print(PostOrder.postOrderByR(createBinTree()));
    }

    /**
     *     4
     *    / \
     *   2   6
     *  /\  / \
     * 1 3  5 7
     *
     * @return
     */
    public static TreeNode createBinTree() {
        TreeNode leaf1 = new TreeNode(1);
        TreeNode leaf3 = new TreeNode(3);
        TreeNode leaf5 = new TreeNode(5);
        TreeNode leaf7 = new TreeNode(7);

        TreeNode left2 = new TreeNode(2, leaf1, leaf3);
        TreeNode right6 = new TreeNode(6, leaf5, leaf7);

        return new TreeNode(4, left2, right6);
    }

    /**
     * 广度优先(迭代法) Breadth First Search (队-左-右)
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
                throw new RuntimeException("树有重复节点或者有环!");
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

    /**
     * 深度优先(迭代法) Depth First Search (栈-右-左)
     * @param root
     * @return
     */
    public static List<Integer> dfs(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            if (result.contains(head.val)) {
                throw new RuntimeException("树有重复节点或者有环!");
            }
            result.add(head.val);
            if (head.right != null) {
                stack.add(head.right);
            }
            if (head.left != null) {
                stack.add(head.left);
            }
        }

        return result;
    }

    /**
     * 深度优先(递归法) (根-左-右)
     * @param root
     * @return
     */
    public static List<Integer> dfsByR(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        return sc(root, result);
    }

    public static List<Integer> sc(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (result.contains(root.val)) {
                throw new RuntimeException("树有重复节点或者有环!");
            }
            result.add(root.val);
            sc(root.left, result);
            sc(root.right, result);
        }

        return result;
    }

    static class PreOrder {

        /**
         * 前序遍历(迭代法) 根左右
         * @param root
         * @return
         */
        public static List<Integer> preOrder(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();

            while (!stack.isEmpty() || root != null) {
                // 迭代访问左子树,并入栈
                while (root != null) {
                    if (result.contains(root.val)) {
                        throw new RuntimeException("树有重复节点或者有环!");
                    }
                    result.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                // 左孩子访问完毕,弹出栈顶节点,访问节点右孩子
                root = stack.pop();
                root = root.right;
            }

            return result;
        }

        private static List<Integer> result = new ArrayList<Integer>();

        /**
         * 前序遍历(递归法) 根左右
         * @param root
         * @return
         */
        public static List<Integer> preOrderByR(TreeNode root) {
            sc(root);
            return result;
        }

        public static void sc(TreeNode root) {
            if (root == null) {
                return;
            }

            result.add(root.val);
            sc(root.left);
            sc(root.right);
        }

    }

    static class InOrder {
        /**
         * 中序遍历(迭代法) 左根右
         * @param root
         * @return
         */
        public static List<Integer> inOrder(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();

            while (!stack.isEmpty() || root != null) {
                // 迭代访问左子树,并入栈
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                // 左孩子访问完毕,弹出栈顶节点,将弹出的节点加入到结果中,访问节点右孩子
                root = stack.pop();
                if (result.contains(root.val)) {
                    throw new RuntimeException("树有重复节点或者有环!");
                }
                result.add(root.val);
                root = root.right;
            }

            return result;
        }

        private static List<Integer> result = new ArrayList<Integer>();

        /**
         * 中序遍历(递归法) 左根右
         * @param root
         * @return
         */
        public static List<Integer> inOrderByR(TreeNode root) {
            sc(root);
            return result;
        }

        public static void sc(TreeNode root) {
            if (root == null) {
                return;
            }

            sc(root.left);
            result.add(root.val);
            sc(root.right);
        }
    }

    static class PostOrder {
        /**
         * 后序遍历(迭代法) 左右根
         * @param root
         * @return
         */
        public static List<Integer> postOrder(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode prev = null;

            while (!stack.isEmpty() || root != null) {
                // 迭代访问左子树,并入栈
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                // 左孩子访问完毕,弹出栈顶节点
                root = stack.pop();

                if (root.right == null || root.right == prev) {
                    if (result.contains(root.val)) {
                        throw new RuntimeException("树有重复节点或者有环!");
                    }
                    result.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }

            return result;
        }

        private static List<Integer> result = new ArrayList<Integer>();

        /**
         * 后序遍历(递归法) 左右根
         * @param root
         * @return
         */
        public static List<Integer> postOrderByR(TreeNode root) {
            sc(root);
            return result;
        }

        public static void sc(TreeNode root) {
            if (root == null) {
                return;
            }

            sc(root.left);
            sc(root.right);
            result.add(root.val);
        }
    }

}