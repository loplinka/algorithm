/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package exercise;

import base.TreeNode;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_前序遍历.java, v 0.1 2023年10月30日 00:47  Baojiang Yang Exp $
 */
public class A2_Tree_前序遍历 {

    List<Integer> res = Lists.newArrayList();

    List<Integer> preorder(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    /* 辅助函数和任何外部变量,使用一个递归得出答案*/
    List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> res = Lists.newArrayList();

        if (root == null) {
            return res;
        }

        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraverse(root.left));
        // 利用函数定义，后面接着右子树的前序遍历结果
        res.addAll(preorderTraverse(root.right));

        return res;
    }
}