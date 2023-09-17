/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

import java.util.LinkedList;

/**
 * @author Baojiang Yang
 * @version 树的遍历: A1_Tree.java, v 0.1 2023年09月17日 02:59  Baojiang Yang Exp $
 */
public class A1_Tree_基础 {
    /**
    * 二叉树的前序遍历
    * @param root
    */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先打印当前节点的值
        System.out.println(root.val);
        // 再打印左子树
        preOrder(root.left);
        // 最后打印右子树
        preOrder(root.right);
    }

    /**
    * 二叉树的中序遍历
    * @param root
    */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先打印左子树
        inOrder(root.left);
        // 再打印当前节点的值
        System.out.println(root.val);
        // 最后打印右子树
        inOrder(root.right);
    }

    /**
    * 二叉树的后序遍历
    * @param root
    */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先打印左子树
        postOrder(root.left);
        // 再打印右子树
        postOrder(root.right);
        // 最后打印当前节点的值
        System.out.println(root.val);
    }


    public static int depth = 0;
    public static int res = 0;

    /**
     * 二叉树的最大深度
     * 这个方式是回溯算法分祖宗(N皇后问题)
     * @param root
     */
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 进之前加1,即指针进入树的下一层
        depth ++;
        // 使用一个res变脸求出最大值
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 返回前-1,即指针返回上一层
        depth --;

    }



    /**
    * 二叉树的最大深度
    *  解法二: 分别求左右子树的最大深度,然后取大,加上1根节点,即为最大深度
     *  次方法是动态规划(凑零钱)的祖宗: 即找规模更小,结构相同的问题,也是分治的思路
    * @param root
    * @return
    */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }




    public static LinkedList<Integer> preOrder  = new LinkedList<>();
    public static LinkedList<Integer> inOrder   = new LinkedList<>();
    public static LinkedList<Integer> postOrder = new LinkedList<>();

    /**
     * 遍历二叉树
     * @param root
     */
    public static void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历代码位置
        preOrder.add(root.val);
        traverse(root.left);
        // 中序遍历代码位置
        inOrder.add(root.val);
        // 后序遍历代码位置
        postOrder.add(root.val);

    }

}