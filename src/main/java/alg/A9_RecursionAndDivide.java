package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *
 * @author baojiang
 * @version 递归和分治: alg.A9_RecursionAndDivide.java, v 0.1 2022年10月03日 下午10:50 baojiang Exp $
 */
public class A9_RecursionAndDivide {

    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(6));
    }

    /**
     * 计算n的阶乘 n!
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n <= 1) {
            return n;
        }
        return n * factorial(n - 1);
    }

    /**
     * 波拉契数列
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}