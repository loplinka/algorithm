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
     *
     * 5.状态转移方程
     *  实际上就是描述问题结构的数学形式
     *  为啥叫「状态转移方程」？其实就是为了听起来高端。
     *  f(n) 的函数参数会不断变化，所以你把参数 n 想做一个状态，这个状态 n 是由状态 n - 1 和状态 n - 2 转移（相加）而来，这就叫状态转移，仅此而已。
     *
     *  可见列出「状态转移方程」的重要性，它是解决问题的核心，而且很容易发现，其实状态转移方程直接代表着暴力解法。
     *  千万不要看不起暴力解，动态规划问题最困难的就是写出这个暴力解，即状态转移方程。
     *  只要写出暴力解，优化方法无非是用备忘录或者 DP table，再无奥妙可言。
     *
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

    /**
     * 根据斐波那契数列的状态转移方程，当前状态 n 只和之前的 n-1, n-2 两个状态有关，其实并不需要那么长的一个 DP table 来存储所有的状态，
     * 只要想办法存储之前的两个状态就行了。
     * 所以，可以进一步优化，把空间复杂度降为 O(1)。这也就是我们最常见的计算斐波那契数的算法
     *
    
     * @param n
     * @return
     */
    private static int fib4(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // 分别代表dp[i-1] 和 dp[i-2]
        int dp_i_1 = 1;
        int dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            //dp[i]=dp[i-1]=dp[i-2]
            int dp_i = dp_i_1 + dp_i_2; // 1+2给i
            // 滚动更新
            dp_i_2 = dp_i_1;// 1给2
            dp_i_1 = dp_i;// i给1
        }

        return dp_i_1;
    }

    /**
     *
     * 这一般是动态规划问题的最后一步优化，如果我们发现每次状态转移只需要 DP table 中的一部分，那么可以尝试缩小 DP table 的大小，只记录必要的数据，从而降低空间复杂度。
     * 上述例子就相当于把 DP table 的大小从 n 缩小到 2
     *
     * 动态规划的另一个重要特性「最优子结构」，怎么没有涉及？下面会涉及。斐波那契数列的例子严格来说不算动态规划，
     * 因为没有涉及求最值，以上旨在说明重叠子问题的消除方法，演示得到最优解法逐步求精的过程。下面，看第二个例子，凑零钱问题。
     */

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib2(10));
        System.out.println(fib3(10));
        System.out.println(fib4(10));
    }

}