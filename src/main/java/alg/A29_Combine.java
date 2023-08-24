package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * 给定两个整数n和k，返回范围[1, n]中所有可能的k个数的组合。你可以按任何顺序返回答案。
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 *
 * @author baojiang
 * @version 组合: A29_combination.java, v 0.1 2022年10月23日 下午4:11 baojiang Exp $
 */
public class A29_Combine {

    public static void main(String[] args) {

        int n = 4;
        int k = 2;
        PrintUtil.printList(combine(n, k));

    }

    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {

        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        if (n <= 0 || k <= 0) {
            return new LinkedList<>();
        }
        backTrack(n, k, 1, track);
        return res;
    }

    public static void backTrack(int n, int k, int start, LinkedList<Integer> track) {

        // 到达树的底部, 触发结束条件
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 注意 i 从 start 开始递增
        for (int i = start; i <= n; i++) {
            // 做选择
            track.add(i);
            // 进入一下层决策树
            backTrack(n, k, i + 1, track);
            // 取消选择
            track.removeLast();
        }

    }

}