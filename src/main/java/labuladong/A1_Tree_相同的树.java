/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_相同的树.java, v 0.1 2023年09月19日 00:47  Baojiang Yang Exp $
 */
public class A1_Tree_相同的树 {

    /**
    * 判断两棵树是否相同
    * @param p
    * @param q
    * @return
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 都为空的话，显然相同
        if (p == null && q == null) {
            return true;
        }
        // 一个为空，一个非空，显然不同
        if (p == null || q == null) {
            return false;
        }
        // 两个都非空，但 val 不一样也不行
        if (p.val != q.val) {
            return false;
        }

        // p 和 q 该比的都比完了
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}