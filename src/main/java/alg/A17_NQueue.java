package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���չ�������Ĺ��򣬻ʺ���Թ�����֮����ͬһ�л�ͬһ�л�ͬһб���ϵ����ӡ�
 *
 * n?�ʺ����� �о�������ν� n?���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 *
 * ����һ������ n ���������в�ͬ��?n?�ʺ����� �Ľ��������
 *
 * ÿһ�ֽⷨ����һ����ͬ��?n �ʺ����� �����ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ
 *
 * ���ӣ�https://leetcode.cn/problems/n-queens
 *
 * labuladong���ͻ����㷨:
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&scene=21#wechat_redirect
 *
 *
 *
 *
 * @author baojiang
 * @version N�ʺ�����: alg.A17_NQueue.java, v 0.1 2022��10��08�� ����12:29 baojiang Exp $
 */
public class A17_NQueue {

    public static void main(String[] args) {
        int n = 4;
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        // Solution.generateBoard(queens, n);

    }

    class Solution {
        // ȫ�ִ���
        List<List<String>> res = new ArrayList<List<String>>();

        // ��ÿ�� �ʺ����ڵ� �� ; Ҳ������map�棻 queue[i] = j ����> ��ʾ��i�еĻʺ���j��
        int[] queue;

        public List<List<String>> solveNQueens(int n) {
            // ��ʼ������
            queue = new int[n];
            Arrays.fill(queue, -1);

            // ����ģ��
            backtrack(n, 0);
            return res;
        }

        // n: n�ʺ�
        // row: ��
        private void backtrack(int n, int row) {

            if (row == n) {
            /*
            ������n�У������浽queue�еĽ�����뵽ȫ�ֽ����
            */
                res.add(generateQueue(n));
                return;
            }

            for (int column = 0; column < n; column++) {
            /*
            ��ǰ�У������ұ�����
            */
                if (!isValid(row, column)) {
                    // �жϵ�ǰ�� ��ǰ�� �Ƿ�����
                    // �������ȥ����һ��
                    continue;
                }
                // ���� ����ǰ�� �� ���뵽������
                queue[row] = column;
                // �ݹ� ��һ��
                backtrack(n, row + 1);
                // ��֮ǰ���뵽�����е��������
                queue[row] = -1;
            }
        }

        private List<String> generateQueue(int n) {
            // ���� n �ʺ�����
            List<String> res = new ArrayList<String>();
            for (int row = 0; row < n; row++) {
                // n �У�ÿ���ȳ�ʼ���� .......
                char[] eachRow = new char[n];
                Arrays.fill(eachRow, '.');
                //�ٴӻ�����ȡ����ǰ�ж�Ӧ�Ļʺ��λ�ã�row[��] = 'Q' ; �� = queue[��]
                eachRow[queue[row]] = 'Q';
                res.add(new String(eachRow));
            }
            return res;
        }

        private boolean isValid(int row, int column) {
            // �жϵ�ǰ �� �� �Ƿ�����
            boolean res = true;
            for (int r = 0; r < row; r++) {
                // ������
                if (queue[r] == -1) {
                    // ����嵱ǰ��û�лʺ� ˵�����в�Ӱ��
                    continue;
                }
                // �����ǲ����������
                if (queue[r] == column || queue[r] + (row - r) == column || queue[r] - (row - r) == column) {
                    // ��ǰ�� �ʺ��� == ��Ҫ����Ļʺ���
                    // ��ǰ�� �ʺ��� �� ��Ҫ����Ļʺ��� �ڶԽ���
                    return false;
                }
            }
            return res;
        }
    }

}