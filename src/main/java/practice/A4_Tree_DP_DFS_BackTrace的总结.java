/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

import base.MultiTreeNode;
import base.TreeNode;
import tools.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Baojiang Yang
 * @version : A3_Tree_DP_DFS_BackTrace���ܽ�.java, v 0.1 2023��11��04�� 16:58  Baojiang Yang Exp $
 */
public class A4_Tree_DP_DFS_BackTrace���ܽ� {

    /**
     * ��̬�滮�㷨���ڷֽ������˼·�����Ĺ�ע�������á���������
     * �����㷨���ڱ�����˼·�����Ĺ�ע���ڽڵ��ġ���֦����
     * DFS �㷨���ڱ�����˼·�����Ĺ�ע���ڵ������ڵ㡹��
     */

    /**
     * ����1:
     * ʹ�÷ֽ������˼·,����һ�������ж��ٸ��ڵ�
     * @param root
     * @return
     */
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // ������ڵ���ĵ����ҵ����������Ľڵ������ֱ��Ƕ���
        int leftCount = count(root.left);
        int rightCount = count(root.right);

        //����λ�ã����������ڵ��������Լ������������Ľڵ���
        return leftCount + rightCount + 1;
    }

    /**
     * �ٿ�������Ķ�̬�滮���⣬���� ��̬�滮�����·��� �оٵ�쳲����������ӣ����ǵĹ�ע����һ�ÿ������ķ���ֵ��
     * @param n
     * @return
     */
    int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    /**
     * ����2:
     * ����һ�ö������������ñ�����˼·дһ�� traverse ��������ӡ��������ö������Ĺ���
     */

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println("�ӽڵ� " + root + "����" + root.left + "�ڵ�");
        traverse(root.left);
        System.out.println("�ӽڵ� " + root.left + "�ص�" + root + "�ڵ�");

        System.out.println("�ӽڵ� " + root + "����" + root.right + "�ڵ�");
        traverse(root.right);
        System.out.println("�ӽڵ� " + root.right + "�ص�" + root + "�ڵ�");

    }

    /**
     * ���ɶ����ͬ��
     * @param root
     */
    void traverse2(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        for (MultiTreeNode child : root.childrens) {
            System.out.println("�ӽڵ� " + root + "����" + child + "�ڵ�");
            traverse2(child);
            System.out.println("�ӽڵ� " + child + "�ص�" + root + "�ڵ�");
        }
    }

    /**
     * �ӱȱ���������������㷨�Ŀ��
     *
     * void backtrack(...) {
     *     for (int i = 0; i < ...; i++) {
     *         // ��ѡ��
     *         ...
     *
     *         // ������һ�������
     *         backtrack(...);
     *
     *         // �����ղ�����ѡ��
     *         ...
     *     }
     * }
     *
     * ����ǻ����㷨������˼·���������۵���Զ���ڽڵ�֮���ƶ��Ĺ��̣���ȵ��������Ͼ��ǡ���֦��
     *
     */

    /**
     * ȫ����
     * �ٿ�������Ļ����㷨���⣬���� �����㷨��ɱ��������Ӽ��ľ������� �н�����ȫ���У����ǵĹ�ע����һ������֦��
     *
     *     void backtrace(int[] nums) {
     *         // �����㷨���
     *         for (int i = 0; i < nums.length; i++) {
     *             // ��ѡ��
     *             used[i] = true;
     *             track.addLast(nums[i]);
     *
     *             // ����һ�²������
     *             backtrace(nums);
     *
     *             // ����ѡ��
     *             track.removeLast();
     *             used[i] = false;
     *         }
     *     }
     */

    /**
     * ���������ӣ��Ҹ���һ�ö�����������дһ�� traverse ����������ö������ϵ�ÿ���ڵ��ֵ����һ���ܼ򵥰ɣ��������£�
     *
     * �㿴������� DFS �㷨������˼·���������۵���Զ���ڵ�һ�Ľڵ��ϣ���ȵ��������Ͼ��Ǵ���ÿ�����ڵ㡹��
     *
     */
    void traverse3(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val++;
        traverse3(root.left);
        traverse3(root.right);
    }

    /**
     *  ���絺������,���ǶԵ����ڵ����,���͵�DFS�㷨
     *
     */
    // DFS �㷨�����߼�
    void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        // ��������ÿ�����ӱ��Ϊ 0
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    /**
     * ��ϸƷһ�����������򵥵����ӣ��ǲ�������˵�ģ���̬�滮��ע���á��������������㷨��ע�ڵ��ġ���֦����DFS �㷨��ע�������ڵ㡹��
     * ������Щ�̵棬��ͺ��������Ϊʲô�����㷨�� DFS �㷨�����С���ѡ�񡹺͡�����ѡ�񡹵�λ�ò�ͬ�ˣ����������δ��룺
     */
    // DFS �㷨�ѡ���ѡ�񡹡�����ѡ�񡹵��߼����� for ѭ������
    void dfs(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        // ��ѡ��
        PrintUtil.print("���Ѿ�����ڵ� %s ��", root);
        for (MultiTreeNode child : root.childrens) {
            dfs(child);
        }
        // ����ѡ��
        PrintUtil.print("�ҽ�Ҫ�뿪�ڵ� %s ��", root);
    }

    // �����㷨�ѡ���ѡ�񡹡�����ѡ�񡹵��߼����� for ѭ������
    void backtrack(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        for (MultiTreeNode child : root.childrens) {
            // ��ѡ��
            PrintUtil.print("��վ�ڽڵ� %s ���ڵ� %s ����֦��", root, child);
            backtrack(child);
            // ����ѡ��
            PrintUtil.print("��վ�ڽڵ� %s ���ڵ� %s ����֦��", child, root);
        }
    }

    /**
     * �����˰ɣ�������㷨����ѡ���ѡ�񡹺͡�����ѡ�񡹵��߼����� for ѭ�����棬������ô�õ�����֦���������˵㣿
     *
     */


    /**
     * �������
     * ������������Ҫ�����������ݹ�˼ά�ģ�������������ڵ���������Ҳ�Ƚϼ򵥣�����͹�һ�´����ܰɣ�
     */

    // ����һ�ö������ĸ��ڵ㣬���������ö�����
    void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // ���ϵ��±�����������ÿһ��
        while (!q.isEmpty()) {
            int sz = q.size();
            // �����ұ���ÿһ���ÿ���ڵ�
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // ����һ��ڵ�������
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }

}