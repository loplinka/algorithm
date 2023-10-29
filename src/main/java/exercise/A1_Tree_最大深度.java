/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package exercise;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_������.java, v 0.1 2023��10��30�� 00:36  Baojiang Yang Exp $
 */
public class A1_Tree_������ {

    int result = 0;
    int depth  = 0;

    int maxDepth(TreeNode root) {
        traverse(root);
        return result;
    }

    /**
     * ǰ��λ���ǽ���һ���ڵ��ʱ�򣬺���λ�����뿪һ���ڵ��ʱ��depth ��¼��ǰ�ݹ鵽�Ľڵ���ȣ���� traverse �����ڶ����������ߵ�һ��ָ�룬���Ե�ȻҪ����ά��
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // ǰ��λ�ü�
        depth++;

        // ����Ҷ�ӽڵ㣬����������
        if (root.left == null && root.right == null) {
            result = Math.max(result, depth);
        }

        traverse(root.left);
        traverse(root.left);

        // ����λ�ü�ȥ
        depth--;
    }

    /* Ҳ����ͨ���ֽ�������,���Ƴ�ԭ����Ĵ�,�ķ�ʽ�����*/
    int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // ���ö��壬��������������������
        int maxLeft = maxDepth2(root.left);
        int maxRight = maxDepth2(root.right);

        int res = Math.max(maxLeft, maxRight) + 1;

        return res;
    }

}