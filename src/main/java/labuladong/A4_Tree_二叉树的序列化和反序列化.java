/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.LinkedList;

import base.TreeNode;

/**
 * @author Baojiang Yang
 *
 * leeCode 297
 * @version : A4_Tree_�����������л��ͷ����л�.java, v 0.1 2023��10��18�� 01:32  Baojiang Yang Exp $
 */
public class A4_Tree_�����������л��ͷ����л� {

    String SEP  = ",";
    String NULL = "#";

    /**
     * ������,�����������л����ַ��� 
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /**
     * ��������,������������StringBuilder
     */
    private void serialize(TreeNode root, StringBuilder sb) {
        // base case
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // ǰ�����λ��
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /**
     * ������,���ַ��������л��ɶ������ṹ
     */
    public TreeNode deserialize(String data) {
        // ���ַ���ת�����б�
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /**
     * ��������,ͨ��nodes�б��������
     */
    private TreeNode deserialize(LinkedList<String> nodes) {
        // base case
        if (nodes.isEmpty()) {
            return null;
        }

        // ǰ�����λ��
        // �б��������Ǹ��ڵ�
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

}