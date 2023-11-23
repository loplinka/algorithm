/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_·����_���η�.java, v 0.1 2023��09��18�� 01:24  Baojiang Yang Exp $
 */
public class A1_Tree_·����_���η� {

    /**
     * leeCode 112. ·���ܺ�
    * ��������·���͵���target��·������
    * @param root
    * @param target
    * @return
    */
    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // Ҷ�ӽڵ�,targetһֱ���¼�ȥ�������Ľڵ��,�ж�Ҷ�ӽڵ��Ƿ����ʣ������target,���ھ͸�ֵ���ؽ�����ǰ�ݹ�
        if (root.left == null && root.right == null && root.val == target) {
            return true;
        }

        // ����ֽ����������������������target - root.val ����������������target - root.val,�κ�һ��������������
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
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

}