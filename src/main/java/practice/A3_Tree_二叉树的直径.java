/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

import base.TreeNode;

/**
 * @author Baojiang Yang
 *
 * leecode 543
 * @version : A2_Tree_��������ֱ��.java, v 0.1 2023��10��30�� 01:09  Baojiang Yang Exp $
 */
public class A3_Tree_��������ֱ�� {

    /**
     * ÿһ���������ġ�ֱ�������ȣ�����һ���ڵ������������������֮��
     */

    // ��¼���ֱ���ĳ���
    int maxDiameter = 0;

    int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // ��ÿ���ڵ����ֱ��
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);
        int myDiameter = maxL + maxR;

        maxDiameter = Math.max(maxDiameter, myDiameter);

        traverse(root.left);
        traverse(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);

        return maxL + maxR + 1;
    }

    /**
     * <p>1.��������ⷨ����ȷ�ģ���������ʱ��ܳ���ԭ��Ҳ�����ԣ�traverse ����ÿ���ڵ��ʱ�򻹻���õݹ麯�� maxDepth���� maxDepth ��Ҫ�������������нڵ�ģ������ʱ�临�Ӷ��� O(N^2)</p>
     * <p>2.��ͳ����˸ղ�̽�ֵ������ǰ��λ���޷���ȡ������Ϣ������ֻ����ÿ���ڵ���� maxDepth ����ȥ����������ȡ�</p>
     * <p>3.������Ż�������Ӧ�ðѼ��㡸ֱ�������߼����ں���λ�ã�׼ȷ˵Ӧ���Ƿ��� maxDepth �ĺ���λ�ã���Ϊ maxDepth �ĺ���λ����֪�����������������ȵġ�</p>
     *
     */

    public int diameterOfBinaryTree2(TreeNode root) {
        maxDepth2(root);
        return maxDiameter;
    }

    int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // ��ÿ���ڵ����ֱ��
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);

        // ����λ�ã�˳��������ֱ��
        int myDiameter = maxL + maxR;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return 1 + Math.max(maxL, maxR);
    }

}