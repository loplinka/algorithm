/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

import base.TreeNode;

/**
 * @author Baojiang Yang
 *
 * leecode 543
 * @version : A2_Tree_二叉树的直径.java, v 0.1 2023年10月30日 01:09  Baojiang Yang Exp $
 */
public class A3_Tree_二叉树的直径 {

    /**
     * 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
     */

    // 记录最大直径的长度
    int maxDiameter = 0;

    int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 对每个节点计算直径
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);
        int myDiameter = maxL + maxR;

        maxDiameter = Math.max(maxDiameter, myDiameter);

        traverse(root.left);
        traverse(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);

        return maxL + maxR + 1;
    }

    /**
     * <p>1.上述这个解法是正确的，但是运行时间很长，原因也很明显，traverse 遍历每个节点的时候还会调用递归函数 maxDepth，而 maxDepth 是要遍历子树的所有节点的，所以最坏时间复杂度是 O(N^2)</p>
     * <p>2.这就出现了刚才探讨的情况，前序位置无法获取子树信息，所以只能让每个节点调用 maxDepth 函数去算子树的深度。</p>
     * <p>3.那如何优化？我们应该把计算「直径」的逻辑放在后序位置，准确说应该是放在 maxDepth 的后序位置，因为 maxDepth 的后序位置是知道左右子树的最大深度的。</p>
     *
     */

    public int diameterOfBinaryTree2(TreeNode root) {
        maxDepth2(root);
        return maxDiameter;
    }

    int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 对每个节点计算直径
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);

        // 后序位置，顺便计算最大直径
        int myDiameter = maxL + maxR;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return 1 + Math.max(maxL, maxR);
    }

}