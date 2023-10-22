/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

import java.util.Stack;

/**
 *
 * leecode 173
 *
 * 实现一个next方法,调用时候返回一个有序遍历(中序)结果
 * 1.最基础的思路:先用数组把中序遍历的结果存起来,然后next方法每次返回一个元素,缺点是占用内存
 * 2.但是迭代器要求是惰性的,要求用到时候才计算返回
 *
 * @author Baojiang Yang
 * @version : A6_Tree_二叉搜索树迭代器.java, v 0.1 2023年10月22日 17:13  Baojiang Yang Exp $
 */
public class A6_Tree_二叉搜索树迭代器 {

    Stack<TreeNode> stk = new Stack<>();

    // 左侧树枝一撸到底
    private void pushLeftBranch(TreeNode p) {
        while (p != null) {
            stk.push(p);
            p = p.left;
        }
    }

    // 构造
    public A6_Tree_二叉搜索树迭代器(TreeNode root) {
        pushLeftBranch(root);
    }

    public int next() {
        TreeNode p = stk.pop();
        pushLeftBranch(p.right);
        return p.val;
    }

    public boolean hasNext() {
        return !stk.isEmpty();
    }

}