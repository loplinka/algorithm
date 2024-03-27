/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package labuladong;

import java.util.Arrays;

/**
 *
 * ���� k ����ֵ��Ӳ�ң���ֵ�ֱ�Ϊ c1, c2 ... ck��ÿ��Ӳ�ҵ��������ޣ��ٸ�һ���ܽ�� amount��
 * ����������Ҫ��öӲ�Ҵճ��������������ܴճ����㷨���� -1 ���㷨�ĺ���ǩ�����£�
 *
 * ����˵ k = 3����ֵ�ֱ�Ϊ 1��2��5���ܽ�� amount = 11����ô������Ҫ 3 öӲ�Ҵճ����� 11 = 5 + 5 + 1��
 *
 * ����ǩ������
 * // coins ���ǿ�ѡӲ����ֵ��amount ��Ŀ����
 * int coinChange(int[] coins, int amount);
 *
 *
 * https://labuladong.online/algo/essential-technique/dynamic-programming-framework-2/#%E4%B8%80%E3%80%81%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%97
 *
 * @author Baojiang Yang
 * @version ����_����Ǯ����: A8_����_����Ǯ����.java, v 0.1 2024��03��26�� 17:05  Baojiang Yang Exp $
 */
public class A8_����_����Ǯ���� {

    /**
     * һ.�����ݹ�ⷨ
     * ��������Ƕ�̬�滮���⣬��Ϊ�����С������ӽṹ���ġ�Ҫ���ϡ������ӽṹ�������������뻥�����
     *
     * �ص�����Ǯ���⣬Ϊʲô˵�����������ӽṹ�أ�����������ֵΪ 1, 2, 5 ��Ӳ�ң������� amount = 11 ʱ������Ӳ������ԭ���⣩��
     * �����֪���ճ� amount = 10, 9, 6 ������Ӳ�����������⣩����ֻ��Ҫ��������Ĵ𰸼�һ����ѡһö��ֵΪ 1, 2, 5 ��Ӳ�ң���
     * �����Сֵ������ԭ����Ĵ𰸡���ΪӲ�ҵ�������û�����Ƶģ�����������֮��û���໥�ƣ��ǻ�������ġ�
     *
     * ��ô����Ȼ֪�������Ǹ���̬�滮���⣬��Ҫ˼������г���ȷ��״̬ת�Ʒ��̣�
     *
     * ��ʽ: ��ȷ base case -> ��ȷ��״̬��-> ��ȷ��ѡ�� -> ���� dp ����/�����ĺ��塣
     *
     * 1��ȷ�� base case������ܼ򵥣���ȻĿ���� amount Ϊ 0 ʱ�㷨���� 0����Ϊ����Ҫ�κ�Ӳ�Ҿ��Ѿ��ճ�Ŀ�����ˡ�
     * 2��ȷ����״̬����Ҳ����ԭ������������л�仯�ı���������Ӳ���������ޣ�Ӳ�ҵ����Ҳ����Ŀ�����ģ�ֻ��Ŀ����᲻�ϵ��� base case ����������Ψһ�ġ�״̬������Ŀ���� amount��
     * 3��ȷ����ѡ�񡹣�Ҳ���ǵ��¡�״̬�������仯����Ϊ��Ŀ����Ϊʲô�仯�أ���Ϊ����ѡ��Ӳ�ң���ÿѡ��һöӲ�ң����൱�ڼ�����Ŀ�������˵����Ӳ�ҵ���ֵ��������ġ�ѡ�񡹡�
     * 4����ȷ dp ����/����Ķ��塣�������ｲ�����Զ����µĽⷨ�����Ի���һ���ݹ�� dp ������һ����˵�����Ĳ�������״̬ת���л�仯������
     *    Ҳ��������˵���ġ�״̬���������ķ���ֵ������ĿҪ�����Ǽ���������ͱ�����˵��״ֻ̬��һ��������Ŀ�������ĿҪ�����Ǽ���ճ�Ŀ�������������Ӳ��������
     *
     * ����������⼸���ؼ��㣬�ⷨ��α��Ϳ���д�����ˣ�
     *
     * // α����
     * int coinChange(int[] coins, int amount) {
     *     // ��ĿҪ������ս���� dp(amount)
     *     return dp(coins, amount)
     * }
     *
     * // ���壺Ҫ�ճ���� n������Ҫ dp(coins, n) ��Ӳ��
     * int dp(int[] coins, int n) {
     *     // ��ѡ��ѡ����ҪӲ�����ٵ��Ǹ����
     *     for (int coin : coins) {
     *         res = min(res, 1 + dp(coins, n - coin))
     *     }
     *     return res
     * }
     * ����α�룬���Ǽ��� base case ���ɵõ����յĴ𰸡���ȻĿ����Ϊ 0 ʱ������Ӳ������Ϊ 0����Ŀ����С�� 0 ʱ���޽⣬���� -1��
     *
     */

    private static int coinChange1(int[] coins, int amount) {
        // ��ĿҪ�����ս����dp(amount)
        return dp1(coins, amount);
    }

    // ����: Ҫ�ճ����n,����Ҫdp(coins, n)��Ӳ��
    private static int dp1(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        // ����ʹ����һ��ѭ��������ÿһ��Ӳ�ҵ���ϡ�����ÿ��Ӳ�ң��������˼�ȥ��ǰӲ����ֵ��������� dp1(coins, amount - coin) �Ľ⣬�����䱣���� subProblem ������
        for (int coin : coins) {
            // ����������Ľ��
            int subProblem = dp1(coins, amount - coin);
            //����������޽⣨������-1�������������Ӳ�ң���Ϊ�������������Ŀ����
            if (subProblem == -1) {
                continue;
            }
            // ����������н⣬�򽫵�ǰӲ�ҵ�������1���� subProblem + 1��Ȼ���� Math.min() ����������СӲ������ res
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * ����������¼�ĵݹ�
     */

    static int[] memo;

    static int coinChange2(int[] coins, int amount) {

        memo = new int[amount + 1];
        // ���ػ�����¼Ϊһ�����ᱻȡ��������ֵ,����û�б����㵽
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

        // ����¼,��ֹ�ظ�����
        if (memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // ������������
            int subProblem = dp2(coins, amount - coin);
            // �������޽�������
            if (subProblem == -1) {
                continue;
            }
            // ����������ѡ�����Ž�,Ȼ��+1
            res = Math.min(res, subProblem + 1);
        }
        // ���������뱸��¼
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    /**
     * ��.dp ����ĵ����ⷨ
     * ��Ȼ������Ҳ�����Ե�����ʹ�� dp table �������ص������⣬���ڡ�״̬����ѡ�񡹺� base case ��֮ǰû������
     * dp ����Ķ���͸ղ� dp �������ƣ�Ҳ�ǰѡ�״̬����Ҳ����Ŀ������Ϊ���������� dp ���������ں����������� dp ��������������������
     *
     *
     * �����������¿�ͷ�����Ķ�̬�滮�����ܿ���д�����½ⷨ��
     *
     * // dp ����Ķ��壺��Ŀ����Ϊ i ʱ��������Ҫ dp[i] öӲ�Ҵճ�
     */
    static int coinChange3(int[] coins, int amount) {

        //�����С Ϊamount+1,
        int[] dp = new int[amount + 1];
        // ��ʼʱ��������������Ԫ�ص�ֵ���Ϊ amount + 1������һ���㹻���ֵ�����ڱ�ʾ��Ч��״̬��
        Arrays.fill(dp, amount + 1);

        // base case, ��Ŀ����Ϊ0ʱ������Ҫ�κ�Ӳ��
        dp[0] = 0;
        // ����ѭ���ڱ�������״̬������ȡֵ,���������п��ܵ�Ŀ���� i
        for (int i = 0; i < dp.length; i++) {
            // �ڲ�ѭ������Ӳ������ coins �е�ÿ��Ӳ��, ��������ѡ�����Сֵ,
            for (int coin : coins) {
                // �������޽�ʱ����
                if (i - coin < 0) {
                    continue;
                }
                // ����ÿ��Ŀ���� i�������ȥÿ��Ӳ����ֵ���������� dp[i - coin]��Ȼ��ȡ���п���Ӳ����ֵ����С�⣬������洢�� dp[i] �С�
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        // ��󣬷��� dp[amount]�����ճ�Ŀ�������������Ӳ��������������յõ���ֵ���� amount + 1��˵���޷��ճ�Ŀ�������-1�����򷵻����յ���СӲ��������
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    /**
     * ����
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