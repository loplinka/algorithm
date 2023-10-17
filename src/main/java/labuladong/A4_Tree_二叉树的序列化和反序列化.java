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
 * @version : A4_Tree_二叉树的序列化和反序列化.java, v 0.1 2023年10月18日 01:32  Baojiang Yang Exp $
 */
public class A4_Tree_二叉树的序列化和反序列化 {

    String SEP  = ",";
    String NULL = "#";

    /**
     * 主函数,将二叉树序列化成字符串 
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /**
     * 辅助函数,将二叉树存入StringBuilder
     */
    private void serialize(TreeNode root, StringBuilder sb) {
        // base case
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // 前序遍历位置
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /**
     * 主函数,将字符串反序列化成二叉树结构
     */
    public TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /**
     * 辅助函数,通过nodes列表构造二叉树
     */
    private TreeNode deserialize(LinkedList<String> nodes) {
        // base case
        if (nodes.isEmpty()) {
            return null;
        }

        // 前序遍历位置
        // 列表最左侧就是根节点
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