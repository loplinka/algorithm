package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *
 * @author baojiang
 * @version �㷨���Ӷ�: On.java, v 0.1 2022��09��26�� ����11:41 baojiang Exp $
 */
public class A2_On {

    /**
     * ����1+2+3+4+...+n
     */

    /**
     * ���Ӷ� O(n)
     * @param n
     * @return
     */
    public static int calc1(int n) {
        int y = 0;
        for (int i = 1; i <= n; i++) {
            y = i + y;
        }
        return y;
    }

    /**
     * ���Ӷ� O(1)
     * @param n
     * @return
     */
    public static int calc2(int n)  {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(calc1(1));
        System.out.println(calc1(2));
        System.out.println(calc1(3));
        System.out.println(calc1(4));

        System.out.println(calc2(1));
        System.out.println(calc2(2));
        System.out.println(calc2(3));
        System.out.println(calc2(4));
    }

    /**
     * 쳲���������
     *
     * 1,1,2,3,5,8,13,21,34....
     * ���Ӷ� O(2~n)
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}