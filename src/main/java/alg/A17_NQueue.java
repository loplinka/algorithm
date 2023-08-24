package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n?皇后问题 研究的是如何将 n?个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的?n?皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的?n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位
 *
 * 链接：https://leetcode.cn/problems/n-queens
 *
 * labuladong解释回溯算法:
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&scene=21#wechat_redirect
 *
 *
 *
 *
 * @author baojiang
 * @version N皇后问题: alg.A17_NQueue.java, v 0.1 2022年10月08日 下午12:29 baojiang Exp $
 */
public class A17_NQueue {

    public static void main(String[] args) {
        int n = 4;
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        // Solution.generateBoard(queens, n);

    }

    class Solution {
        // 全局存结果
        List<List<String>> res = new ArrayList<List<String>>();

        // 存每行 皇后所在的 列 ; 也可以用map存； queue[i] = j ——> 表示第i行的皇后在j列
        int[] queue;

        public List<List<String>> solveNQueens(int n) {
            // 初始化缓存
            queue = new int[n];
            Arrays.fill(queue, -1);

            // 回溯模版
            backtrack(n, 0);
            return res;
        }

        // n: n皇后
        // row: 行
        private void backtrack(int n, int row) {

            if (row == n) {
            /*
            遍历完n行，将缓存到queue中的结果加入到全局结果里
            */
                res.add(generateQueue(n));
                return;
            }

            for (int column = 0; column < n; column++) {
            /*
            当前行，从左到右遍历列
            */
                if (!isValid(row, column)) {
                    // 判断当前行 当前列 是否满足
                    // 不满足就去找下一列
                    continue;
                }
                // 满足 将当前行 列 加入到缓存中
                queue[row] = column;
                // 递归 下一行
                backtrack(n, row + 1);
                // 将之前加入到缓存中的数据清空
                queue[row] = -1;
            }
        }

        private List<String> generateQueue(int n) {
            // 生成 n 皇后棋盘
            List<String> res = new ArrayList<String>();
            for (int row = 0; row < n; row++) {
                // n 行；每行先初始化成 .......
                char[] eachRow = new char[n];
                Arrays.fill(eachRow, '.');
                //再从缓存中取出当前行对应的皇后的位置，row[列] = 'Q' ; 列 = queue[行]
                eachRow[queue[row]] = 'Q';
                res.add(new String(eachRow));
            }
            return res;
        }

        private boolean isValid(int row, int column) {
            // 判断当前 行 列 是否满足
            boolean res = true;
            for (int r = 0; r < row; r++) {
                // 遍历行
                if (queue[r] == -1) {
                    // 缓存冲当前行没有皇后 说明这行不影响
                    continue;
                }
                // 以下是不满足的条件
                if (queue[r] == column || queue[r] + (row - r) == column || queue[r] - (row - r) == column) {
                    // 当前行 皇后列 == 将要放入的皇后列
                    // 当前行 皇后列 与 将要放入的皇后列 在对角线
                    return false;
                }
            }
            return res;
        }
    }

}