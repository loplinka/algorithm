package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 树和图
 * @author baojiang
 * @version 数和图: Tree.java, v 0.1 2022年10月01日 下午6:56 baojiang Exp $
 */
public class A7_TreeAndGraph {

    public static void main(String[] args) {

        TreeNode leaf1 =  new TreeNode(1);
        TreeNode leaf3 =  new TreeNode(3);
        TreeNode leaf5 =  new TreeNode(5);
        TreeNode leaf7 =  new TreeNode(7);

        TreeNode left2 =  new TreeNode(2, leaf1, leaf3);
        TreeNode right6 =  new TreeNode(6, leaf5, leaf7);

        TreeNode root =  new TreeNode(4, left2, right6);

        System.out.println(isValidBST2(root));

    }

    /**
     * 验证一棵树是否是二叉搜索树BST
     * Tips: BST不能只看根节点的左节点和右节点来和根节点比较,而是要看整个左子树和整个右子树来和根节点比较
     * 方法1: 使用中序遍历In-Order,得到一个升序数组(数组没有必要全部保留,保留上一个元素和当前元素即可)
     * 方法2: 使用递归Recursion
     *        递归获取左子树Max
     *        递归获取右子树Min
     *        然后 max<root<min
     *
     */


    /**
     * 中序遍历法:[中序遍历得到一个递增数列]
     * 经典的两层嵌套循环当前Node,然后入栈,从根节点开始,然后左子树,出栈,右子树
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        // 初始化最小值,用作第一个节点的比较
        double inorder = -Double.MAX_VALUE;

        // 两层嵌套循环, 分别遍历左右节点
        // 要么压入的栈不为空(非叶子节点),要么遍历当前节点不为空(叶子节点)
        while (!stack.isEmpty() || root != null) {
            // 遍历左子树,压入栈
            while (root != null) {
                stack.push(root);// 当前遍历节点入栈
                root = root.left;// 然后遍历左子树
            }
            // 出栈比较
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            // 记录当前节点值
            inorder = root.val;
            // 循环体遍历右子树
            root = root.right;
        }

        return true;
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        // 如果 root 节点的值 val 不在 (l,r) 的范围内说明不满足条件直接返回
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // 继续递归调用检查它的左右子树是否满足，如果都满足才说明这是一棵二叉搜索树
        // 在递归调用左子树时，我们需要把上界 upper 改为 root.val，即调用 isValidBST(root.left, lower, root.val)，因为左子树里所有节点的值均小于它的根节点的值。
        // 同理递归调用右子树时，我们需要把下界 lower 改为 root.val，即调用 helper(root.right, root.val, upper)
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }




}