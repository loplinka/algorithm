/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.LinkedList;

import base.TreeNode;
import com.google.common.collect.Lists;

/**
 * @author Baojiang Yang
 * @version 树的遍历: A1_Tree.java, v 0.1 2023年09月17日 02:59  Baojiang Yang Exp $
 */
public class A1_Tree_基础 {

    /**
     * 二叉树解决问题的两大思路
     * 1.是否能遍历一遍就解决问题,比如下边的traverse
     * 2.是否能把问题分解成规模更小的子问题来反推原问题的结果,比如下边的preOrderTraversal
     *      (1)函数的额定义是什么,明确定义,相信定义,不要跳进递归细节
     *      (2)利用这个节点,把当前该做的事情做好,然后把剩下的事情抛给框架
     *
     * 几个要点:
     * 1.二叉树的数据结构天然就带有递归的性质
     * 2.因为二叉树是每个节点左右子树都是规模更小但是结构都相同的子问题,所以可以用规模更小的子问题来推到原问题结果
     * 3.二叉树天然适合培养递归思维,所以如果给一个根节点,你天然就要想到我能不能把这个问题运用到规模更小的子节点上(分治和动态规划)
     * 比如路劲和、最大深度和相同的树问题,都是这个思路
     * 4.要明确一个递归函数的定义并且相信这个定义,不要跳进递归细节!
     */

    public static LinkedList<Integer> preOrder  = new LinkedList<>();
    public static LinkedList<Integer> inOrder   = new LinkedList<>();
    public static LinkedList<Integer> postOrder = new LinkedList<>();

    /**
     * 遍历二叉树,递归法
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

    /**
     * 前序遍历二叉树,分治法
     * 1.首先定义一个函数,相信他能遍历出前序的结果
     * 2.然后分别遍历左右子树,把结果合并起来,最终得到整棵树的结果
     * @param root
     */
    public static LinkedList<Integer> preOrderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        // 前序遍历代码位置
        res.add(root.val);
        res.addAll(preOrderTraversal(root.left));
        res.addAll(preOrderTraversal(root.right));

        return res;
    }

    /**
     * 前序遍历,分治法
     * 1.首先顶一个函数,相信他能遍历出前序结果
     * 2.然后后分别遍历左右子树,把结果合并起来,最终得到整课树的结果
     *
     * @param root
     * @return
     */

    public static LinkedList<Integer> preOrderMS(TreeNode root) {
        LinkedList<Integer> res = Lists.newLinkedList();
        if (root == null) {
            return res;
        }

        // 前序遍历位置
        res.add(root.val);
        res.addAll(preOrderMS(root.left));
        res.addAll(preOrderMS(root.right));
        return res;
    }

}