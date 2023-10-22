/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 *  leecode 1008
 * @version : A6_Tree_前序遍历构造二叉搜索树.java, v 0.1 2023年10月22日 16:57  Baojiang Yang Exp $
 */
public class A6_Tree_前序遍历构造二叉搜索树 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    public TreeNode build(int[] preOrder, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }

        // 第一个值是根节点的值
        int rootVal = preOrder[start];
        TreeNode root = new TreeNode(rootVal);

        // 确定左右子树的边界
        int p = start + 1;
        if (p <= end && preOrder[p] < rootVal) {
            p++;
        }

        // 生成所有子树
        root.left = build(preOrder, start + 1, p - 1);
        root.right = build(preOrder, p, end);

        return root;
    }


    /**
     * 总结
     * 还原二叉树: 1需要确定根节点,2需要确定根节点的左右子树有哪些
     *
     * 普通二叉树: 需要一个前序结果+一个中序结果,才能还原二叉树,因为需要前序确定根节点,中序确定根节点的左右子树
     * BST:值需要一个前序就可以还原出BST,以为第一个就是根节点,而根据值的大小,就可以确定左右子树(左小右大)
     *
     */

}