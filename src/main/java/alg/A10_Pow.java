package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 * ����x��n�η� Pow(x,n) No.50
 *
 * https://leetcode.cn/problems/powx-n/solution/powx-n-by-leetcode-solution/
 *
 * @author baojiang
 * @version ��: alg.A10_Pow.java, v 0.1 2022��10��03�� ����11:18 baojiang Exp $
 */
public class A10_Pow {

    public static void main(String[] args) {

        System.out.println(Solution2.myPow(2, 10));
        System.out.println(Solution1.myPow(2, 10));

    }

    /**
     * ����һ�������� + �ݹ�
     */
    static class Solution1 {
        public static double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }

        public static double quickMul(double x, long N) {
            System.out.println(x + "��" + N +"����");
            if (N == 0) {
                return 1.0;
            }
            double y = quickMul(x, N / 2);
            System.out.println("y=" + y);
            return N % 2 == 0 ? y * y : y * y * x;
        }
    }

    /**
     * �������������� + ����
     */
    static class Solution2 {
        public static double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }

        public static double quickMul(double x, long N) {
            double ans = 1.0;
            // ���׵ĳ�ʼֵΪ x
            double x_contribute = x;
            // �ڶ� N ���ж����Ʋ�ֵ�ͬʱ�����
            while (N > 0) {
                if (N % 2 == 1) {
                    // ��� N �����Ʊ�ʾ�����λΪ 1����ô��Ҫ���빱��
                    ans *= x_contribute;
                }
                // �����ײ��ϵ�ƽ��
                x_contribute *= x_contribute;
                // ���� N �����Ʊ�ʾ�����λ����������ÿ��ֻҪ�ж����λ����
                N /= 2;
                System.out.println("ans=" + ans + " N=" + N);
            }
            return ans;
        }
    }



}