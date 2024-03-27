/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package labuladong;

import java.util.Arrays;

/**
 *
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
 * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。算法的函数签名如下：
 *
 * 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
 *
 * 函数签名如下
 * // coins 中是可选硬币面值，amount 是目标金额
 * int coinChange(int[] coins, int amount);
 *
 *
 * https://labuladong.online/algo/essential-technique/dynamic-programming-framework-2/#%E4%B8%80%E3%80%81%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%97
 *
 * @author Baojiang Yang
 * @version 动规_凑零钱问题: A8_动规_凑零钱问题.java, v 0.1 2024年03月26日 17:05  Baojiang Yang Exp $
 */
public class A8_动规_凑零钱问题 {

    /**
     * 一.暴力递归解法
     * 这个问题是动态规划问题，因为它具有「最优子结构」的。要符合「最优子结构」，子问题间必须互相独立
     *
     * 回到凑零钱问题，为什么说它符合最优子结构呢？假设你有面值为 1, 2, 5 的硬币，你想求 amount = 11 时的最少硬币数（原问题），
     * 如果你知道凑出 amount = 10, 9, 6 的最少硬币数（子问题），你只需要把子问题的答案加一（再选一枚面值为 1, 2, 5 的硬币），
     * 求个最小值，就是原问题的答案。因为硬币的数量是没有限制的，所以子问题之间没有相互制，是互相独立的。
     *
     * 那么，既然知道了这是个动态规划问题，就要思考如何列出正确的状态转移方程？
     *
     * 公式: 明确 base case -> 明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义。
     *
     * 1、确定 base case，这个很简单，显然目标金额 amount 为 0 时算法返回 0，因为不需要任何硬币就已经凑出目标金额了。
     * 2、确定「状态」，也就是原问题和子问题中会变化的变量。由于硬币数量无限，硬币的面额也是题目给定的，只有目标金额会不断地向 base case 靠近，所以唯一的「状态」就是目标金额 amount。
     * 3、确定「选择」，也就是导致「状态」产生变化的行为。目标金额为什么变化呢，因为你在选择硬币，你每选择一枚硬币，就相当于减少了目标金额。所以说所有硬币的面值，就是你的「选择」。
     * 4、明确 dp 函数/数组的定义。我们这里讲的是自顶向下的解法，所以会有一个递归的 dp 函数，一般来说函数的参数就是状态转移中会变化的量，
     *    也就是上面说到的「状态」；函数的返回值就是题目要求我们计算的量。就本题来说，状态只有一个，即「目标金额」，题目要求我们计算凑出目标金额所需的最少硬币数量。
     *
     * 搞清楚上面这几个关键点，解法的伪码就可以写出来了：
     *
     * // 伪码框架
     * int coinChange(int[] coins, int amount) {
     *     // 题目要求的最终结果是 dp(amount)
     *     return dp(coins, amount)
     * }
     *
     * // 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
     * int dp(int[] coins, int n) {
     *     // 做选择，选择需要硬币最少的那个结果
     *     for (int coin : coins) {
     *         res = min(res, 1 + dp(coins, n - coin))
     *     }
     *     return res
     * }
     * 根据伪码，我们加上 base case 即可得到最终的答案。显然目标金额为 0 时，所需硬币数量为 0；当目标金额小于 0 时，无解，返回 -1：
     *
     */

    private static int coinChange1(int[] coins, int amount) {
        // 题目要求最终结果是dp(amount)
        return dp1(coins, amount);
    }

    // 定义: 要凑出金额n,至少要dp(coins, n)个硬币
    private static int dp1(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        // 这里使用了一个循环来尝试每一种硬币的组合。对于每个硬币，它计算了减去当前硬币面值后的子问题 dp1(coins, amount - coin) 的解，并将其保存在 subProblem 变量中
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp1(coins, amount - coin);
            //如果子问题无解（即返回-1），则跳过这个硬币，因为它不能用于组成目标金额
            if (subProblem == -1) {
                continue;
            }
            // 如果子问题有解，则将当前硬币的数量加1，即 subProblem + 1，然后用 Math.min() 方法更新最小硬币数量 res
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 二、带备忘录的递归
     */

    static int[] memo;

    static int coinChange2(int[] coins, int amount) {

        memo = new int[amount + 1];
        // 树池华备忘录为一个不会被取到的特殊值,代表还没有被计算到
        Arrays.fill(memo, -666);
        return dp2(coins, amount);
    }

    static int dp2(int[] coins, int amount) {

        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        // 备忘录,防止重复计算
        if (memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题结果
            int subProblem = dp2(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) {
                continue;
            }
            // 在子问题中选择最优解,然后+1
            res = Math.min(res, subProblem + 1);
        }
        // 计算结果放入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    /**
     * 三.dp 数组的迭代解法
     * 当然，我们也可以自底向上使用 dp table 来消除重叠子问题，关于「状态」「选择」和 base case 与之前没有区别，
     * dp 数组的定义和刚才 dp 函数类似，也是把「状态」，也就是目标金额作为变量。不过 dp 函数体现在函数参数，而 dp 数组体现在数组索引：
     *
     *
     * 根据我们文章开头给出的动态规划代码框架可以写出如下解法：
     *
     * // dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出
     */
    static int coinChange3(int[] coins, int amount) {

        //数组大小 为amount+1,
        int[] dp = new int[amount + 1];
        // 初始时，将数组中所有元素的值填充为 amount + 1，这是一个足够大的值，用于表示无效的状态。
        Arrays.fill(dp, amount + 1);

        // base case, 当目标金额为0时，不需要任何硬币
        dp[0] = 0;
        // 外层的循环在遍历所有状态的所有取值,即遍历所有可能的目标金额 i
        for (int i = 0; i < dp.length; i++) {
            // 内层循环遍历硬币数组 coins 中的每个硬币, 并求所有选择的最小值,
            for (int coin : coins) {
                // 子问题无解时跳过
                if (i - coin < 0) {
                    continue;
                }
                // 对于每个目标金额 i，计算减去每个硬币面值后的子问题解 dp[i - coin]，然后取所有可能硬币面值的最小解，并将其存储在 dp[i] 中。
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        // 最后，返回 dp[amount]，即凑出目标金额所需的最少硬币数量。如果最终得到的值等于 amount + 1，说明无法凑出目标金额，返回-1；否则返回最终的最小硬币数量。
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        int[] coins = new int[] { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange1(coins, amount));
        System.out.println(coinChange2(coins, amount));
        System.out.println(coinChange3(coins, amount));
    }

}