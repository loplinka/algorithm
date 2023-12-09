/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A2_Tree_打印出每个节点的左右子树各有多少节点.java, v 0.1 2023年10月30日 01:06  Baojiang Yang Exp $
 */
public class A2_Tree_打印出每个节点的左右子树各有多少节点 {

    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int countLeft = count(root.left);
        int countRight = count(root.right);

        System.out.println("节点 %s 的左子树有 %d 个节点，右子树有 %d 个节点" + root + countLeft + countRight);
        return countLeft + countRight +1;
    }
    
    public int count2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lCount = count2(root.left);
        int rCount = count2(root.right);

        return lCount + rCount + 1;
    }
}