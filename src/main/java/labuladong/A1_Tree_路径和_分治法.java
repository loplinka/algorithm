/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_路径和_分治法.java, v 0.1 2023年09月18日 01:24  Baojiang Yang Exp $
 */
public class A1_Tree_路径和_分治法 {

    /**
    * 二叉树中路径和等于target的路径数量
    * @param root
    * @param target
    * @return
    */
    public boolean pathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // 叶子节点,target一直往下减去遍历过的节点后,判断叶子节点是否等于剩下最后的target,等于就赋值返回结束当前递归
        if (root.left == null && root.right == null) {
            return root.val == target;
        }

        // 问题分解成在左子树和右子树中找target - root.val 或者在右子树中找target - root.val,任何一个满足条件即可
        return pathSum(root.left, target - root.val) || pathSum(root.right, target - root.val);
    }

}