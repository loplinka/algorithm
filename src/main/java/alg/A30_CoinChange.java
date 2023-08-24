package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.Arrays;

/**
 *
 *
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247493719&idx=1&sn=edfeed0628a26fd665a105fa003bfaa2&chksm=9bd4165faca39f49946dcbe3f2b98f3a2eb5fa0efe980ebf904d2dce6841f5f6241c149ef80f&scene=178&cur_album_id=2165170016067944448#rd
 *
 * 给你一个整数数组coins，表示不同面额的硬币；以及一个整数amount，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1（你可以认为每种硬币的数量是无限的）。
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 *
 * @author baojiang
 * @version 零钱兑换: alg.A30_CoinChange.java, v 0.1 2022年10月23日 下午5:23 baojiang Exp $
 */
public class A30_CoinChange {

    class Solution {
        int[] memo;

        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            // dp 数组全都初始化为特殊值
            Arrays.fill(memo, -666);
            return dp(coins, amount);
        }

        int dp(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            // 查备忘录，防止重复计算
            if (memo[amount] != -666) {
                return memo[amount];
            }

            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 计算子问题的结果
                int subProblem = dp(coins, amount - coin);
                // 子问题无解则跳过
                if (subProblem == -1) continue;
                // 在子问题中选择最优解，然后加一
                res = Math.min(res, subProblem + 1);
            }
            // 把计算结果存入备忘录
            memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }

}