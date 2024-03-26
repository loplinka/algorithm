/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package labuladong;

/**
 *
 * @author Baojiang Yang
 * @version 动规_斐波那契数列: A8_动规_斐波那契数列.java, v 0.1 2024年03月26日 12:18  Baojiang Yang Exp $
 */
public class A8_动规_斐波那契数列 {

    /**
     * 动态规划概述:
     * 1.动态规划问题的一般形式就是求最值
     * 2.求解动态规划的核心问题是穷举
     *  穷举所有可行解其实并不是一件容易的事，需要你熟练掌握递归思维，只有列出正确的「状态转移方程」，才能正确地穷举。
     *  而且，你需要判断算法问题是否具备「最优子结构」，是否能够通过子问题的最值得到原问题的最值
     *  另外，动态规划问题存在「重叠子问题」,「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。
     *
     *3.动规三要素
     *  重叠子问题、最优子结构、状态转移方程就是动态规划三要素
     *
     *4.思维框架
     * 思维框架，辅助你思考状态转移方程：
     *
     * 明确 base case -> 明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义。
     *
     */

    /**
     * 初版
     * @param n
     * @return
     */
    private static int fib(int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 带备忘录(DP Table)的解法
     * 自顶向下的解法,因为是从较大规模的f(20)，向下逐渐分解规模，直到 f(1) 和 f(2) 这两个 base case，然后逐层返回答案
     * @param n
     * @return
     */
    private static int fib2(int n) {
        // 备忘录全部初始化为0
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    private static int dp(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }
        // 已经计算过
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    /**
     * 啥叫「自底向上」？反过来，我们直接从最底下、最简单、问题规模最小、已知结果的 f(1) 和 f(2)（base case）开始往上推，直到推到我们想要的答案 f(20)。
     * 这就是「递推」的思路，这也是动态规划一般都脱离了递归
     *
     * 有了上一步「备忘录」的启发，我们可以把这个「备忘录」独立出来成为一张表，通常叫做 DP table，在这张表上完成「自底向上」的推算
     * @param n
     * @return
     */
    private static int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib2(10));
        System.out.println(fib3(10));
    }

}