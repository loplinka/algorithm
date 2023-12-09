/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version ·����: A1_Tree_·����.java, v 0.1 2023��09��17�� 12:42  Baojiang Yang Exp $
 */
public class A1_Tree_·����_���ݷ� {

    static boolean found  = false;
    static int     curSum = 0;
    static int     target = 0;

    /**
     * �Ƿ���ں�targetSum��ȵ�·����
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        target = targetSum;
        traverse(root);
        return found;
    }

    /**
     * ����
     * @param root
     */
    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // ǰ�����λ��
        curSum += root.val;
        // �Ƿ���Ҷ�ӽڵ�
        if (root.left == null && root.left == null) {
            if (target == curSum) {
                found = true;
            }
        }
        traverse(root.left);
        traverse(root.right);
        // �������λ��
        curSum -= root.val;
    }

    public static void main(String[] args) {
        // д�������㷨�Ĳ�������
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int target = 22;

        System.out.println(hasPathSum(root, target));
    }

    static boolean found2 = false;
    static int curSum2 = 0;
    static int target2 = 0;

    public static boolean hasPathSum2(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        target2 = target;
        traverse2(root);
        return found2;
    }

    private static void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        // ǰ����ѡ��
        curSum2 = curSum2 + root.val;

        // Ҷ�ӽڵ�
        if (root.left == null && root.right == null && curSum2 == target2) {
            found2 = true;
        }
        traverse2(root.left);
        traverse2(root.right);

        // ������ѡ��
        curSum2 = curSum2 - root.val;

    }
    
    
    public boolean hasPathSum4(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        traverse3(root);
        return found2;
    }
    
    
    public void traverse3(TreeNode root) {
        if (root == null) {
            return;
        }

        curSum2 = curSum2 + root.val;
        if (root.left == null && root.right == null && curSum2 == target2) {
            found2 = true;
        }

        traverse3(root.left);
        traverse3(root.right);

        curSum2 = curSum2 - root.val;

    }
    

}