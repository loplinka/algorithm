/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.Stack;

import base.TreeNode;

/**
 * 在实际中迭代改递归意义不大,并不利于理解递归和培养计算机思维,只是为了考察堆栈的思维
 * @author Baojiang Yang
 * @version : A1_Tree_二叉树递归改迭代.java, v 0.1 2023年09月21日 01:00  Baojiang Yang Exp $
 */
public class A1_Tree_二叉树递归改迭代 {

    Stack<TreeNode> stk = new Stack<>();

    /**
     * 二叉树的递归遍历
     *
     * @param root
     */
    public void traverse(TreeNode root) {
        // 前序遍历
        stk.push(root);
        traverse(root.left);
        // 中序遍历
        traverse(root.right);
        // 后序遍历
        stk.pop();
    }

    // **改写成如下迭代方法***

    /**
     * 迭代法
     * @param root
     */
    public void traverse2(TreeNode root) {
        // 指向上一次编辑完的子树根节点
        TreeNode visited = new TreeNode(-1);

        // 开始遍历整棵树
        pushLeftBranch(root);

        while (!stk.isEmpty()) {
            TreeNode p = stk.peek();
            // p的左子树被遍历完了,而且右子树没有被遍历过
            if ((p.left == null || p.left == visited) && p.right != visited) {
                /* 中序遍历位置**/
                // 将右子树入栈
                pushLeftBranch(p.right);
            }
            // p的右子树被遍历完了
            if (p.right == null || p.right == visited) {
                /* 后序遍历位置**/
                // 以p为根的子树已经遍历完了,出栈,并将visited指向p
                visited = stk.pop();
            }
        }
    }

    /**
     * 左侧树枝一撸到底
     * @param p
     */
    public void pushLeftBranch(TreeNode p) {
        while (p != null) {
            /* 前序遍历位置**/
            stk.push(p);
            p = p.left;
        }
    }

}