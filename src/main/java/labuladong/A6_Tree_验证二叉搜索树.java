/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A6_Tree_验证二叉搜索树.java, v 0.1 2023年10月21日 14:28  Baojiang Yang Exp $
 */
public class A6_Tree_验证二叉搜索树 {

    /**
     * leeCode 98
     * 验证二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /** 判断一颗一root为根的BST的值是否在min和max之间
     * min和max不用int是因为需要初始化成Integer.MAX和MIN,测试用例会出两个值作为用例导致代码不兼容,所以使用TreeNode
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }

        // 左子树应该在root和min之间,右子树应该在max和root之间,左子树的最大值是root, 有子树的最小值是root
        return isValidBST(root.left, root, min) && isValidBST(root.left, max, root);

    }

}