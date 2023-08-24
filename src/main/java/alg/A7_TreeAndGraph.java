package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ����ͼ
 * @author baojiang
 * @version ����ͼ: Tree.java, v 0.1 2022��10��01�� ����6:56 baojiang Exp $
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
     * ��֤һ�����Ƿ��Ƕ���������BST
     * Tips: BST����ֻ�����ڵ����ڵ���ҽڵ����͸��ڵ�Ƚ�,����Ҫ���������������������������͸��ڵ�Ƚ�
     * ����1: ʹ���������In-Order,�õ�һ����������(����û�б�Ҫȫ������,������һ��Ԫ�غ͵�ǰԪ�ؼ���)
     * ����2: ʹ�õݹ�Recursion
     *        �ݹ��ȡ������Max
     *        �ݹ��ȡ������Min
     *        Ȼ�� max<root<min
     *
     */


    /**
     * ���������:[��������õ�һ����������]
     * ���������Ƕ��ѭ����ǰNode,Ȼ����ջ,�Ӹ��ڵ㿪ʼ,Ȼ��������,��ջ,������
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        // ��ʼ����Сֵ,������һ���ڵ�ıȽ�
        double inorder = -Double.MAX_VALUE;

        // ����Ƕ��ѭ��, �ֱ�������ҽڵ�
        // Ҫôѹ���ջ��Ϊ��(��Ҷ�ӽڵ�),Ҫô������ǰ�ڵ㲻Ϊ��(Ҷ�ӽڵ�)
        while (!stack.isEmpty() || root != null) {
            // ����������,ѹ��ջ
            while (root != null) {
                stack.push(root);// ��ǰ�����ڵ���ջ
                root = root.left;// Ȼ�����������
            }
            // ��ջ�Ƚ�
            root = stack.pop();
            // �����������õ��Ľڵ��ֵС�ڵ���ǰһ�� inorder��˵�����Ƕ���������
            if (root.val <= inorder) {
                return false;
            }
            // ��¼��ǰ�ڵ�ֵ
            inorder = root.val;
            // ѭ�������������
            root = root.right;
        }

        return true;
    }

    /**
     * �ݹ鷨
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
        // ��� root �ڵ��ֵ val ���� (l,r) �ķ�Χ��˵������������ֱ�ӷ���
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // �����ݹ���ü���������������Ƿ����㣬����������˵������һ�ö���������
        // �ڵݹ����������ʱ��������Ҫ���Ͻ� upper ��Ϊ root.val�������� isValidBST(root.left, lower, root.val)����Ϊ�����������нڵ��ֵ��С�����ĸ��ڵ��ֵ��
        // ͬ��ݹ����������ʱ��������Ҫ���½� lower ��Ϊ root.val�������� helper(root.right, root.val, upper)
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }




}