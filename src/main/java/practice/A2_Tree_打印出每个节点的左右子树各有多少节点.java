/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

import base.TreeNode;

/**
 * @author Baojiang Yang
 * @version : A2_Tree_��ӡ��ÿ���ڵ�������������ж��ٽڵ�.java, v 0.1 2023��10��30�� 01:06  Baojiang Yang Exp $
 */
public class A2_Tree_��ӡ��ÿ���ڵ�������������ж��ٽڵ� {

    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int countLeft = count(root.left);
        int countRight = count(root.right);

        System.out.println("�ڵ� %s ���������� %d ���ڵ㣬�������� %d ���ڵ�" + root + countLeft + countRight);
        return countLeft + countRight +1;
    }
    
    public int count2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lCount = count2(root.left);
        int rCount = count2(root.right);

        return lCount + rCount + 1;
    }
}