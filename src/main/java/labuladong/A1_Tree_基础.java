/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.LinkedList;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version 树的遍历: A1_Tree.java, v 0.1 2023年09月17日 02:59  Baojiang Yang Exp $
 */
public class A1_Tree_基础 {

    public static LinkedList<Integer> preOrder  = new LinkedList<>();
    public static LinkedList<Integer> inOrder   = new LinkedList<>();
    public static LinkedList<Integer> postOrder = new LinkedList<>();

    /**
     * 遍历二叉树
     * @param root
     */
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历代码位置
        preOrder.add(root.val);
        traverse(root.left);
        // 中序遍历代码位置
        inOrder.add(root.val);
        traverse(root.right);
        // 后序遍历代码位置
        postOrder.add(root.val);

    }

    public static void main(String[] args) {
        // 测试用例

    }

}