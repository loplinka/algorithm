package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 * 计算x的n次方 Pow(x,n) No.50
 *
 * https://leetcode.cn/problems/powx-n/solution/powx-n-by-leetcode-solution/
 *
 * @author baojiang
 * @version 幂: alg.A10_Pow.java, v 0.1 2022年10月03日 下午11:18 baojiang Exp $
 */
public class A10_Pow {

    public static void main(String[] args) {

        System.out.println(Solution2.myPow(2, 10));
        System.out.println(Solution1.myPow(2, 10));

    }

    /**
     * 方法一：快速幂 + 递归
     */
    static class Solution1 {
        public static double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }

        public static double quickMul(double x, long N) {
            System.out.println(x + "的" + N +"次幂");
            if (N == 0) {
                return 1.0;
            }
            double y = quickMul(x, N / 2);
            System.out.println("y=" + y);
            return N % 2 == 0 ? y * y : y * y * x;
        }
    }

    /**
     * 方法二：快速幂 + 迭代
     */
    static class Solution2 {
        public static double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }

        public static double quickMul(double x, long N) {
            double ans = 1.0;
            // 贡献的初始值为 x
            double x_contribute = x;
            // 在对 N 进行二进制拆分的同时计算答案
            while (N > 0) {
                if (N % 2 == 1) {
                    // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                    ans *= x_contribute;
                }
                // 将贡献不断地平方
                x_contribute *= x_contribute;
                // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
                N /= 2;
                System.out.println("ans=" + ans + " N=" + N);
            }
            return ans;
        }
    }



}