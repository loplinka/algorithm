package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法详解
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&scene=21#wechat_redirect
 *
 * @author baojiang
 * @version 回溯法: alg.A27_BackTrack.java, v 0.1 2022年10月23日 下午1:43 baojiang Exp $
 */
public class A27_BackTrack {

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3 };

        PrintUtil.printList(Solution.permute(arr));

    }

    /**
     * 回溯法解决全排列问题
     */
    static class Solution {

        public static List<List<Integer>> res = new LinkedList<>();

        public static List<List<Integer>> permute(int[] nums) {
            // 记录路径
            LinkedList<Integer> track = new LinkedList<>();
            backTrack(nums, track);
            return res;
        }

        /**
         * 其核心就是 for 循环里面的递归，在递归调用之前「做选择」，在递归调用之后「撤销选择」，
         * @param nums
         * @param track
         */
        public static void backTrack(int[] nums, LinkedList<Integer> track) {

            // 触发结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 排除不合法的选择
                if (track.contains(nums[i])) {
                    continue;
                }
                // 做选择
                track.add(nums[i]);
                // 进入一下层决策树
                backTrack(nums, track);
                // 取消选择
                track.removeLast();
            }

        }

    }

}