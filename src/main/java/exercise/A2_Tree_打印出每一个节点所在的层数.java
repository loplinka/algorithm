/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package exercise;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A2_Tree_打印出每一个节点所在的层数.java, v 0.1 2023年10月30日 01:02  Baojiang Yang Exp $
 */
public class A2_Tree_打印出每一个节点所在的层数 {

    void level(TreeNode root) {
        traverse(root, 1);
    }

    private void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        System.out.println("节点 %s 在第 %d 层" + root + level);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);

    }
}