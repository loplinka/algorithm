/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package labuladong;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Baojiang Yang
 * @version N�ʺ�����: A7_����_N�ʺ�.java, v 0.1 2024��03��19�� 19:27  Baojiang Yang Exp $
 */
public class A7_����_N�ʺ� {

    /**
     * ��������������� N = 4����ô���Ҫ�� 4x4 �������Ϸ��� 4 ���ʺ󣬷������½������ . ��������̣�Q ����ʺ�
     * [
     *     [".Q..","...Q","Q...","..Q."],
     *     ["..Q.","Q...","...Q",".Q.."]
     * ]
     *
     *
     */

    List<List<String>> res = new ArrayList<>();

    /* �������̱߳� n���������кϷ��ķ��� */
    public List<List<String>> solveNQueens(int n) {
        // '.' ��ʾ�գ�'Q' ��ʾ�ʺ󣬳�ʼ��������
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;
    }

    // ·����board ��С�� row ����Щ�ж��Ѿ��ɹ������˻ʺ�
    // ѡ���б��� row �е������ж��Ƿ��ûʺ��ѡ��
    // ����������row ���� board �����һ��
    void backtrack(List<String> board, int row) {
        // ������������
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // �ų����Ϸ�ѡ��
            if (!isValid(board, row, col)) {
                continue;
            }
            // ��ѡ��
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());

            // ������һ�о���
            backtrack(board, row + 1);
            // ����ѡ��
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }
    }

    /* �Ƿ������ board[row][col] ���ûʺ� */
    boolean isValid(List<String> board, int row, int col) {
        int n = board.size();

        /* ������Ƿ��лʺ����ͻ */
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        /* ������Ϸ��Ƿ��лʺ����ͻ */
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        /* ������Ϸ��Ƿ��лʺ����ͻ */
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }
}