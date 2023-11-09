/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

import base.MultiTreeNode;
import base.TreeNode;
import tools.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Baojiang Yang
 * @version : A3_Tree_DP_DFS_BackTrace的总结.java, v 0.1 2023年11月04日 16:58  Baojiang Yang Exp $
 */
public class A4_Tree_DP_DFS_BackTrace的总结 {

    /**
     * 动态规划算法属于分解问题的思路，它的关注点在整棵「子树」。
     * 回溯算法属于遍历的思路，它的关注点在节点间的「树枝」。
     * DFS 算法属于遍历的思路，它的关注点在单个「节点」。
     */

    /**
     * 案例1:
     * 使用分解问题的思路,计算一棵树上有多少个节点
     * @param root
     * @return
     */
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 我这个节点关心的是我的两个子树的节点总数分别是多少
        int leftCount = count(root.left);
        int rightCount = count(root.right);

        //后序位置，左右子树节点数加上自己就是整棵树的节点数
        return leftCount + rightCount + 1;
    }

    /**
     * 再看看具体的动态规划问题，比如 动态规划框架套路详解 中举的斐波那契的例子，我们的关注点在一棵棵子树的返回值上
     * @param n
     * @return
     */
    int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 案例2:
     * 给你一棵二叉树，请你用遍历的思路写一个 traverse 函数，打印出遍历这棵二叉树的过程
     */

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println("从节点 " + root + "进入" + root.left + "节点");
        traverse(root.left);
        System.out.println("从节点 " + root.left + "回到" + root + "节点");

        System.out.println("从节点 " + root + "进入" + root.right + "节点");
        traverse(root.right);
        System.out.println("从节点 " + root.right + "回到" + root + "节点");

    }

    /**
     * 换成多叉树同理
     * @param root
     */
    void traverse2(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        for (MultiTreeNode child : root.childrens) {
            System.out.println("从节点 " + root + "进入" + child + "节点");
            traverse2(child);
            System.out.println("从节点 " + child + "回到" + root + "节点");
        }
    }

    /**
     * 从比便可以衍生出回溯算法的框架
     *
     * void backtrack(...) {
     *     for (int i = 0; i < ...; i++) {
     *         // 做选择
     *         ...
     *
     *         // 进入下一层决策树
     *         backtrack(...);
     *
     *         // 撤销刚才做的选择
     *         ...
     *     }
     * }
     *
     * 这就是回溯算法遍历的思路，它的着眼点永远是在节点之间移动的过程，类比到二叉树上就是「树枝」
     *
     */

    /**
     * 全排列
     * 再看看具体的回溯算法问题，比如 回溯算法秒杀排列组合子集的九种题型 中讲到的全排列，我们的关注点在一条条树枝上
     *
     *     void backtrace(int[] nums) {
     *         // 回溯算法框架
     *         for (int i = 0; i < nums.length; i++) {
     *             // 做选择
     *             used[i] = true;
     *             track.addLast(nums[i]);
     *
     *             // 进入一下层决策树
     *             backtrace(nums);
     *
     *             // 撤销选择
     *             track.removeLast();
     *             used[i] = false;
     *         }
     *     }
     */

    /**
     * 第三个例子，我给你一棵二叉树，请你写一个 traverse 函数，把这棵二叉树上的每个节点的值都加一。很简单吧，代码如下：
     *
     * 你看，这就是 DFS 算法遍历的思路，它的着眼点永远是在单一的节点上，类比到二叉树上就是处理每个「节点」。
     *
     */
    void traverse3(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val++;
        traverse3(root.left);
        traverse3(root.right);
    }

    /**
     *  比如岛屿问题,就是对单个节点操作,典型的DFS算法
     *
     */
    // DFS 算法核心逻辑
    void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        // 遍历过的每个格子标记为 0
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    /**
     * 仔细品一下上面三个简单的例子，是不是像我说的：动态规划关注整棵「子树」，回溯算法关注节点间的「树枝」，DFS 算法关注单个「节点」。
     * 有了这些铺垫，你就很容易理解为什么回溯算法和 DFS 算法代码中「做选择」和「撤销选择」的位置不同了，看下面两段代码：
     */
    // DFS 算法把「做选择」「撤销选择」的逻辑放在 for 循环外面
    void dfs(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        // 做选择
        PrintUtil.print("我已经进入节点 %s 啦", root);
        for (MultiTreeNode child : root.childrens) {
            dfs(child);
        }
        // 撤销选择
        PrintUtil.print("我将要离开节点 %s 啦", root);
    }

    // 回溯算法把「做选择」「撤销选择」的逻辑放在 for 循环里面
    void backtrack(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        for (MultiTreeNode child : root.childrens) {
            // 做选择
            PrintUtil.print("我站在节点 %s 到节点 %s 的树枝上", root, child);
            backtrack(child);
            // 撤销选择
            PrintUtil.print("我站在节点 %s 到节点 %s 的树枝上", child, root);
        }
    }

    /**
     * 看到了吧，你回溯算法必须把「做选择」和「撤销选择」的逻辑放在 for 循环里面，否则怎么拿到「树枝」的两个端点？
     *
     */


    /**
     * 层序遍历
     * 二叉树题型主要是用来培养递归思维的，而层序遍历属于迭代遍历，也比较简单，这里就过一下代码框架吧：
     */

    // 输入一棵二叉树的根节点，层序遍历这棵二叉树
    void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 从上到下遍历二叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 将下一层节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }

}