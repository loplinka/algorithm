/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 *
 * @author Baojiang Yang
 * @version : A2_Tree_DFS_递归法.java, v 0.1 2023年09月26日 18:22  Baojiang Yang Exp $
 */
public class A2_Tree_最大深度_DFS_递归法 {

    int depth = 0;
    int res   = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return depth;
        }
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置: 进入之前做选择
        depth++;
        // 到达叶子节点,才比较最小直
        if (root.left == null && root.right == null) {
            res = Math.max(depth, res);
        }
        traverse(root.left);
        traverse(root.right);
        // 后续遍历位置: 退出后撤销选择
        depth--;
    }

    /** 上述的基础写法,便于理解递归,可以把上述方法的外部成员写到函数里边 */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = maxDepth2(root.left);
        int maxRight = maxDepth2(root.right);
        return 1 + Math.max(maxLeft, maxRight);
    }

}