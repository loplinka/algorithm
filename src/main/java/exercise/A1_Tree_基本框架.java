/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package exercise;

import base.ListNode;
import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_基本框架.java, v 0.1 2023年10月29日 18:16  Baojiang Yang Exp $
 */
public class A1_Tree_基本框架 {

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历
        traverse(root.left);
        // 中序遍历
        traverse(root.right);
        // 后序遍历
    }

    /* 迭代遍历数组 */
    void traverse2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 迭代访问arr[i]
        }
    }

    /* 递归遍历数组 */
    void traverse3(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        traverse3(arr, i + 1);
    }

    /*迭代访问单链表*/
    void traverse4(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {

        }

    }


    /*递归访问单链表*/
    void traverse5(ListNode head) {
        if (head == null) {
            return;
        }

        traverse5(head.next);
    }


    /*倒序答应单链表上所有值*/
     void traverse6(ListNode head) {
         if (head == null) {
             return;
         }
         traverse6(head.next);
         // 后续遍历位置打印
         System.out.println(head.val);

     }


    /**
     * 二叉树递归是算法分两类思路:
     * 1.便利一遍就能二叉树得出答案,对应:回溯算法框架(Backtrace),没有返回值
     * 2.通过分解子问题得到原问题的答案,对应:动态规划框架(Dynamic Programming) 有返回值,如果可以，写出这个递归函数的定义，并充分利用这个函数的返回值。
     * 3.无论使用哪一种思维模式，你都要明白二叉树的每一个节点需要做什么，需要在什么时候（前中后序）做
     *
     * 前序位置的代码执行是自顶向下的，而后序位置的代码执行是自底向上的：
     *
     * 前序位置是刚刚进入节点的时刻，后序位置是即将离开节点的时刻。
     *
     * 但这里面大有玄妙，意味着前序位置的代码只能从函数参数中获取父节点传递来的数据，而后序位置的代码不仅可以获取参数数据，还可以获取到子树通过函数返回值传递回来的数据。
     *
     */





}