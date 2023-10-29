/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package exercise;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_最大深度.java, v 0.1 2023年10月30日 00:36  Baojiang Yang Exp $
 */
public class A1_Tree_最大深度 {

    int result = 0;
    int depth  = 0;

    int maxDepth(TreeNode root) {
        traverse(root);
        return result;
    }

    /**
     * 前序位置是进入一个节点的时候，后序位置是离开一个节点的时候，depth 记录当前递归到的节点深度，你把 traverse 理解成在二叉树上游走的一个指针，所以当然要这样维护
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序位置加
        depth++;

        // 到达叶子节点，更新最大深度
        if (root.left == null && root.right == null) {
            result = Math.max(result, depth);
        }

        traverse(root.left);
        traverse(root.left);

        // 后续位置减去
        depth--;
    }

    /* 也可以通过分解子问题,反推出原问题的答案,的方式来解答*/
    int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 利用定义，计算左右子树的最大深度
        int maxLeft = maxDepth2(root.left);
        int maxRight = maxDepth2(root.right);

        int res = Math.max(maxLeft, maxRight) + 1;

        return res;
    }

}