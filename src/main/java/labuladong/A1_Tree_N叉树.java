/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.LinkedList;
import java.util.List;

import base.MultiTreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_N叉树.java, v 0.1 2023年09月18日 00:31  Baojiang Yang Exp $
 */
public class A1_Tree_N叉树 {

    List<Integer> res = new LinkedList<>();

    public List<Integer> preorder(MultiTreeNode root) {
        traverse(root);
        return res;
    }

    /**
     * N叉树的遍历,记住没有中序遍历
     * @param root
     */
    public void traverse(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历
        res.add(root.val);
        for (MultiTreeNode child : root.childrens) {
            traverse(child);
        }
        // 后序遍历
    }

    /**
     * 如果把前序和后序遍历放到for循环内,仅仅只会跳过根节点,其效果和不放入之前是一样的
     * @param root
     */
    public void traverse2(MultiTreeNode root) {
        if (root == null) {
            return;
        }

        for (MultiTreeNode child : root.childrens) {
            // 前序遍历
            res.add(child.val);
            traverse2(child);
            // 后序遍历
        }

    }
}