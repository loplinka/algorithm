/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A4_Tree_��ǰ�������������������.java, v 0.1 2023��10��18�� 00:43  Baojiang Yang Exp $
 */
public class A4_Tree_��ǰ������������������� {

    /**
     * leeCode 105
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * �ݹ鹹�������
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // ǰ������ĵ�һ���ڵ���Ǹ��ڵ�
        int rootVal = preorder[preStart];
        // ������������ҵ����ڵ��λ��
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // ��������и��ڵ����߾����������Ľڵ�,�ұ߾����������Ľڵ�
        int leftSize = index - inStart;
        // ������ڵ�
        TreeNode root = new TreeNode(rootVal);
        // �ݹ鹹����������
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);

        return root;

    }

}