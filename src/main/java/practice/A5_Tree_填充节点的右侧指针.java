/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

import base.ThreeNode;

/**
 * @author Baojiang Yang
 * @version : A5_Tree_填充节点的右侧指针.java, v 0.1 2023年11月10日 00:28  Baojiang Yang Exp $
 */
public class A5_Tree_填充节点的右侧指针 {

    // 主函数
    ThreeNode connect(ThreeNode root) {
        if (root == null)
            return null;
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架
    void traverse(ThreeNode node1, ThreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** 前序位置 ****/
        // 将传入的两个节点穿起来
        node1.next = node2;

        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        traverse(node1.right, node2.left);
    }

}