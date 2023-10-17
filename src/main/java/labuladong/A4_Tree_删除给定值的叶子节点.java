/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A3_Tree_ɾ������ֵ��Ҷ�ӽڵ�.java, v 0.1 2023��10��18�� 00:20  Baojiang Yang Exp $
 */
public class A4_Tree_ɾ������ֵ��Ҷ�ӽڵ� {

    /**
     * leeCode 1325
     * ˼��
     * 1.��ǰ�ڵ�Ӧ��Ҫ��ʲô����(��ĿҪ��); ��ʲôʱ����(ǰ�к������)
     * 2.ǰ�����:������������ڵ��λ��; ��������:�����뿪����ڵ��λ��;
     * 3.����ֻ�к������,�����뿪�ڵ�ʱ�����ж��Լ��Ƿ���Ҷ�ӽڵ�,�Ӷ��������null
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        // �������λ�� �ж��Ƿ���Ҷ�ӽڵ�
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}