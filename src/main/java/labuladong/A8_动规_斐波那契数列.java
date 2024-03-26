/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package labuladong;

/**
 *
 * @author Baojiang Yang
 * @version ����_쳲���������: A8_����_쳲���������.java, v 0.1 2024��03��26�� 12:18  Baojiang Yang Exp $
 */
public class A8_����_쳲��������� {

    /**
     * ��̬�滮����:
     * 1.��̬�滮�����һ����ʽ��������ֵ
     * 2.��⶯̬�滮�ĺ������������
     *  ������п��н���ʵ������һ�����׵��£���Ҫ���������յݹ�˼ά��ֻ���г���ȷ�ġ�״̬ת�Ʒ��̡���������ȷ����١�
     *  ���ң�����Ҫ�ж��㷨�����Ƿ�߱��������ӽṹ�����Ƿ��ܹ�ͨ�����������ֵ�õ�ԭ�������ֵ
     *  ���⣬��̬�滮������ڡ��ص������⡹,������¼�����ߡ�DP table�����Ż���ٹ��̣����ⲻ��Ҫ�ļ��㡣
     *
     *3.������Ҫ��
     *  �ص������⡢�����ӽṹ��״̬ת�Ʒ��̾��Ƕ�̬�滮��Ҫ��
     *
     *4.˼ά���
     * ˼ά��ܣ�������˼��״̬ת�Ʒ��̣�
     *
     * ��ȷ base case -> ��ȷ��״̬��-> ��ȷ��ѡ�� -> ���� dp ����/�����ĺ��塣
     *
     */

    /**
     * ����
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
     * ������¼(DP Table)�Ľⷨ
     * �Զ����µĽⷨ,��Ϊ�Ǵӽϴ��ģ��f(20)�������𽥷ֽ��ģ��ֱ�� f(1) �� f(2) ������ base case��Ȼ����㷵�ش�
     * @param n
     * @return
     */
    private static int fib2(int n) {
        // ����¼ȫ����ʼ��Ϊ0
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    private static int dp(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }
        // �Ѿ������
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    /**
     * ɶ�С��Ե����ϡ���������������ֱ�Ӵ�����¡���򵥡������ģ��С����֪����� f(1) �� f(2)��base case����ʼ�����ƣ�ֱ���Ƶ�������Ҫ�Ĵ� f(20)��
     * ����ǡ����ơ���˼·����Ҳ�Ƕ�̬�滮һ�㶼�����˵ݹ�
     *
     * ������һ��������¼�������������ǿ��԰����������¼������������Ϊһ�ű�ͨ������ DP table�������ű�����ɡ��Ե����ϡ�������
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
        // ״̬ת��
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