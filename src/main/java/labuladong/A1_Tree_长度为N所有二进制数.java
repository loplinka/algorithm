/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_长度为N所有二进制数.java, v 0.1 2023年09月18日 00:42  Baojiang Yang Exp $
 */
public class A1_Tree_长度为N所有二进制数 {

    static StringBuilder path = new StringBuilder();

    /**
     * 生成长度为N所有二进制数
     * 1.其实就求二叉树的遍历的所有可能的路劲
     * 2.其核心思想就是把一个问题转化成N叉树的遍历问题
     * 3.记住基于N叉数据的基本遍历框架,然后把前序和后续遍历放到for循环内,即不遍历根节点
     * 4.最后再回忆一下N叉数据的遍历框架:
     *  step1: 从根节点往叶子节点遍历,即在进入前序的时候做记录(绿色剪头)
     *  step2: 当遍历完从叶子节点往根节点返回时,要维护,即逆向操作,要么--要么删除(红色剪头)
     * 5.这就是回溯算法的核心思想
     * @param n
     *
     */
    static void genBinNumber(int n) {
        if (n == 0) {
            System.out.println(path.toString());
            return;
        }

        // 此处2是多少扫就代表几进制,比如是10就是10进制
        for (int i = 0; i < 2; i++) {
            // 前序位置,进入节点
            path.append(i);
            // 递归子节点, 此时的n就是层数,每走一层就减1
            genBinNumber(n - 1);
            // 后序位置,离开节点
            path.deleteCharAt(path.length() - 1);
        }

    }

    public static void main(String[] args) {
        genBinNumber(3);
    }

}