/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A5_Tree_纲领篇.java, v 0.1 2023年11月09日 22:51  Baojiang Yang Exp $
 */
public class A5_Tree_翻转二叉树 {

    /**
     * 翻转二叉树
     * leecode 226
     * 不难发现，只要把二叉树上的每一个节点的左右子节点进行交换，最后的结果就是完全翻转之后的二叉树。
     */

    /**
     *  1、这题能不能用「遍历」的思维模式解决？
     * 可以，我写一个 traverse 函数遍历每个节点，让每个节点的左右子节点颠倒过来就行了。
     * 单独抽出一个节点，需要让它做什么？让它把自己的左右子节点交换一下。
     * 需要在什么时候做？好像前中后序位置都可T以。
     * 综上，可以写出如下解法代码：
     */
    TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 每一个节点需要做的事就是交换它的左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 遍历框架，去遍历左右子树的节点
        traverse(root.left);
        traverse(root.right);

    }

    /**
     * 2、这题能不能用「分解问题」的思维模式解决？
     *
     * 我们尝试给 invertTree 函数赋予一个定义：
     *
     * // 定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
     * TreeNode invertTree(TreeNode root);
     *
     */

    TreeNode revertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 利用函数定义，先翻转左右子树
        TreeNode left = revertTree(root.left);
        TreeNode right = revertTree(root.right);

        // 然后交换左右子节点
        root.left = right;
        root.right = left;

        // 和定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
        return root;
    }

    /**
     * 这种「分解问题」的思路，核心在于你要给递归函数一个合适的定义，然后用函数的定义来解释你的代码；如果你的逻辑成功自恰，那么说明你这个算法是正确的。
     * 好了，这道题就分析到这，「遍历」和「分解问题」的思路都可以解决
     *
     */

}