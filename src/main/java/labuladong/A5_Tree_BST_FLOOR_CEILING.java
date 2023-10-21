/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A5_Tree_BST_FLOOR_CEILING.java, v 0.1 2023年10月21日 10:50  Baojiang Yang Exp $
 */
public class A5_Tree_BST_FLOOR_CEILING {

    /**
     * 基于leeCode 700 SBT的搜索
     * 如果目标值不存在,返回比目标值大的最小的key,或者比目标值小的最大的key
     */

    public TreeNode searchBSTFloor(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (root.val < val) {
            // 到右子树去找, 第一个发现返回为空的,把自己返回回去,这样就可以一路接收到这个值floor key
            TreeNode x = searchBSTFloor(root.right, val);
            if (x == null) {
                return root;
            }
            return x;
        } else {
            // 到左子树去找
            return searchBSTFloor(root.left, val);

        }
    }

    public TreeNode searchBSTCeiling(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (root.val < val) {
            // 到右子树去找,
            return searchBSTCeiling(root.right, val);

        } else {
            // 到左子树去找, 第一个发现返回为空的,把自己返回回去,这样就可以一路接收到这个值celling key
            TreeNode x = searchBSTCeiling(root.left, val);
            if (x == null) {
                return root;
            }
            return x;

        }
    }
}