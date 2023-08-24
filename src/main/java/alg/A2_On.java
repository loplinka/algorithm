package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *
 * @author baojiang
 * @version 算法复杂度: On.java, v 0.1 2022年09月26日 下午11:41 baojiang Exp $
 */
public class A2_On {

    /**
     * 计算1+2+3+4+...+n
     */

    /**
     * 复杂度 O(n)
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
     * 复杂度 O(1)
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
     * 斐波拉契数组
     *
     * 1,1,2,3,5,8,13,21,34....
     * 复杂度 O(2~n)
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