/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_最小深度.java, v 0.1 2023年09月17日 22:56  Baojiang Yang Exp $
 */
public class A1_Tree_最小深度_DFS_递归法 {

    /**
     * 递归就是DFS算法, 和BFS区别是时间复杂度都一样,空间复杂度不一样
     * 1.DFS(递归法):    时间复杂度复杂度一定=O(n)因为一定要全部递归结束才能得出结论, 空间复杂O(树高度)
     * 2.BFS(层序遍历法): 时间复杂度复杂度理论上=O(n),实际上大概率<O(n),因为只要遇到第一个叶子节点就会提前结束,空间复杂度是O(2的层数次方)
     */

    static int depth = 0;
    static int res   = Integer.MAX_VALUE;

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return res;
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.left == null) {
            res = Math.min(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    /**
     * 上述算法可以改写成如下形式,把所有变量纳入到函数内
     */
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth2(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth2(root.right), min_depth);
        }

        return min_depth + 1;
    }

    /**
     *     3
     *    / \
     *   9   20
     *      / \
     *     15 7
     *      \
     *      4
     * @return
     */
    public static TreeNode createBinTree() {
        TreeNode leaf7 = new TreeNode(7);
        TreeNode leaf4 = new TreeNode(4);

        TreeNode parent15 = new TreeNode(15, null, leaf4);

        TreeNode left9 = new TreeNode(9, null, null);
        TreeNode right20 = new TreeNode(20, parent15, leaf7);

        return new TreeNode(3, left9, right20);
    }

    public static void main(String[] args) {
        // 测试用例
        TreeNode root = createBinTree();
        traverse(root);
        System.out.println(res);
    }
}