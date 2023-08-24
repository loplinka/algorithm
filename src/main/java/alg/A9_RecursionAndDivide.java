package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *
 * @author baojiang
 * @version �ݹ�ͷ���: alg.A9_RecursionAndDivide.java, v 0.1 2022��10��03�� ����10:50 baojiang Exp $
 */
public class A9_RecursionAndDivide {

    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(6));
    }

    /**
     * ����n�Ľ׳� n!
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
     * ����������
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