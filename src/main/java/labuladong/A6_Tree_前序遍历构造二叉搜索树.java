/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 *  leecode 1008
 * @version : A6_Tree_ǰ������������������.java, v 0.1 2023��10��22�� 16:57  Baojiang Yang Exp $
 */
public class A6_Tree_ǰ������������������ {

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    public TreeNode build(int[] preOrder, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }

        // ��һ��ֵ�Ǹ��ڵ��ֵ
        int rootVal = preOrder[start];
        TreeNode root = new TreeNode(rootVal);

        // ȷ�����������ı߽�
        int p = start + 1;
        if (p <= end && preOrder[p] < rootVal) {
            p++;
        }

        // ������������
        root.left = build(preOrder, start + 1, p - 1);
        root.right = build(preOrder, p, end);

        return root;
    }


    /**
     * �ܽ�
     * ��ԭ������: 1��Ҫȷ�����ڵ�,2��Ҫȷ�����ڵ��������������Щ
     *
     * ��ͨ������: ��Ҫһ��ǰ����+һ��������,���ܻ�ԭ������,��Ϊ��Ҫǰ��ȷ�����ڵ�,����ȷ�����ڵ����������
     * BST:ֵ��Ҫһ��ǰ��Ϳ��Ի�ԭ��BST,��Ϊ��һ�����Ǹ��ڵ�,������ֵ�Ĵ�С,�Ϳ���ȷ����������(��С�Ҵ�)
     *
     */

}