/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_��С���.java, v 0.1 2023��09��17�� 22:56  Baojiang Yang Exp $
 */
public class A1_Tree_��С��� {
    int depth = 0;
    int res   = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.left == null) {
            res = Math.min(res, depth);
        }
        depth++;
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}