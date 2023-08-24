package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 * ����һ������ prices �����ĵ�?i ��Ԫ��?prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�
 * ��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ�����һ���㷨�����������ܻ�ȡ���������
 * ��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺[7,1,5,3,6,4]
 * �����5
 * ���ͣ��ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
 *      ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�ͬʱ���㲻��������ǰ������Ʊ��
 * ʾ�� 2��
 *
 * ���룺prices = [7,6,4,3,1]
 * �����0
 * ���ͣ������������, û�н������, �����������Ϊ 0��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * @author baojiang
 * @version ������Ʊ����: alg.A11_BySellStock.java, v 0.1 2022��10��04�� ����5:28 baojiang Exp $
 */
public class A11_BySellStock {

    public static void main(String[] args) {
        int[] prices  = new int[]{7,1,5,3,6,4};
        System.out.println(Solution2.maxProfit(prices));
    }

    static class Solution1 {
        public static int maxProfit(int[] prices) {
            // ��������м����
            int maxprofit = 0;
            // �ӵ�0���۸�ʼ����n-1��
            for (int i = 0; i < prices.length - 1; i++) {
                // �ӵ�1���۸�ʼ����
                for (int j = i + 1; j < prices.length; j++) {
                    // ����=�������۸� - ǰ����۸�
                    int profit = prices[j] - prices[i];
                    if (profit > maxprofit) {
                        maxprofit = profit;
                    }
                }
            }
            return maxprofit;
        }
    }

    /**
     * һ�α���
     * �м������¼��ͼ۸�minprice,
     * �������������ͼ۸�,����prices[i]-minprice�õ�maxProfit
     */
    static class Solution2 {
        public static int maxProfit(int prices[]) {
            //������¼һ����ʷ��ͼ۸�
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                // Ҫô�ǵͼ�
                if (prices[i] < minprice) {
                    minprice = prices[i];
                    System.out.println("minprice=" + minprice);
                }
                // Ҫô����,�Ϳ�������������
                else if (prices[i] - minprice > maxprofit) {
                    maxprofit = prices[i] - minprice;
                    System.out.println("maxprofit=" + maxprofit);
                }
            }
            return maxprofit;
        }
    }



}