/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package base;

/**
 *
 * @author baojiang
 * @version �������ڵ�: TreeNode.java, v 0.1 2022��10��01�� ����9:58 baojiang Exp $
 */
public class TreeNode {

    public int      val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}