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
    * ��������·���͵���target��·������
    * @param root
    * @param target
    * @return
    */
    public boolean pathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // Ҷ�ӽڵ�,targetһֱ���¼�ȥ�������Ľڵ��,�ж�Ҷ�ӽڵ��Ƿ����ʣ������target,���ھ͸�ֵ���ؽ�����ǰ�ݹ�
        if (root.left == null && root.right == null) {
            return root.val == target;
        }

        // ����ֽ����������������������target - root.val ����������������target - root.val,�κ�һ��������������
        return pathSum(root.left, target - root.val) || pathSum(root.right, target - root.val);
    }

}