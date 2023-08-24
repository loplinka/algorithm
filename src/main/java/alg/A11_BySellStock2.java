package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *  https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 *
 * ����һ���������� prices ������?prices[i] ��ʾĳ֧��Ʊ�� i ��ļ۸�
 * ��ÿһ�죬����Ծ����Ƿ����/����۹�Ʊ�������κ�ʱ��?���?ֻ�ܳ��� һ�� ��Ʊ����Ҳ�����ȹ���Ȼ���� ͬһ�� ���ۡ�
 * ���� ���ܻ�õ� ��� ����?��
 *
 * ʾ�� 1��
 * ���룺prices = [7,1,5,3,6,4]
 * �����7
 * ���ͣ��ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 3 �죨��Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5 - 1 = 4 ��
 * ?    ����ڵ� 4 �죨��Ʊ�۸� = 3����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ������, ��ʽ������ܻ������ = 6 - 3 = 3 ��
 *      ������Ϊ 4 + 3 = 7 ��
 *
 * ʾ�� 2��
 * ���룺prices = [1,2,3,4,5]
 * �����4
 * ���ͣ��ڵ� 1 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �� ����Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5 - 1 = 4 ��
 * ?    ������Ϊ 4
 *
 * @author baojiang
 * @version ������Ʊ����: alg.A11_BySellStock.java, v 0.1 2022��10��04�� ����5:02 baojiang Exp $
 */
public class A11_BySellStock2 {

    public static void main(String[] args) {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(Solution1.maxProfit(prices));
        System.out.println(Solution2.maxProfit(prices));
    }

    /**
     * ̰���㷨 Greedy
     * ��������û������,��˿��Ե��������������,���Կ����������, ������ȼ���:
     * 1.��һ�����,�ڶ�������,����Ƶ���Ľ�����������С��Ԫ������
     * 2.�����С��Ԫ������Ϊ��,���0ȡMax,�����С��Ԫ������Ϊ��(��Ϊ���Ž�),���ۼ�����
     * 3.��С��ԪΪ���Ž�,��ŵ�ȫ�ֿ�Ҳ�����Ž�
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
     * ��̬�滮�㷨 DP
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