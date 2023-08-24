package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *  https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 *
 * 给你一个整数数组 prices ，其中?prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候?最多?只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润?。
 *
 * 示例 1：
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * ?    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 *
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * ?    总利润为 4
 *
 * @author baojiang
 * @version 买卖股票问题: alg.A11_BySellStock.java, v 0.1 2022年10月04日 下午5:02 baojiang Exp $
 */
public class A11_BySellStock2 {

    public static void main(String[] args) {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(Solution1.maxProfit(prices));
        System.out.println(Solution2.maxProfit(prices));
    }

    /**
     * 贪心算法 Greedy
     * 由于买卖没有限制,因此可以当天买进次日卖出,来试看收益的正负, 该问题等价于:
     * 1.第一天买进,第二天卖出,以最频繁的交易来试算最小单元的利益
     * 2.如果最小单元的利益为负,则和0取Max,如果最小单元的利益为正(即为最优解),则累加下来
     * 3.最小单元为最优解,则放到全局看也是最优解
     */
    static class Solution1 {
        public static int maxProfit(int[] prices) {
            int ans = 0;
            int n = prices.length;
            for (int i = 1; i < n; ++i) {
                int unitProfit = Math.max(0, prices[i] - prices[i - 1]);
                ans = ans + unitProfit;
                System.out.println("unitProfit=" + unitProfit + " ans=" + ans);
            }
            return ans;
        }
    }

    /**
     * 动态规划算法 DP
     */
    static class Solution2 {
        public static int maxProfit(int[] prices) {
            int n = prices.length;
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < n; ++i) {
                int newDp0 = Math.max(dp0, dp1 + prices[i]);
                int newDp1 = Math.max(dp1, dp0 - prices[i]);
                dp0 = newDp0;
                dp1 = newDp1;
            }
            return dp0;
        }
    }

}