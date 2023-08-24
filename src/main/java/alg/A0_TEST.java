/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package alg;

/**
 * @author Baojiang Yang
 * @version TEST: A0.java, v 0.1 2023Äê06ÔÂ20ÈÕ 16:22  Baojiang Yang Exp $
 */
public class A0_TEST {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        a = b;
        System.out.println(a);
        b = c;
        System.out.println(a);
        c = new Integer(4);
        System.out.println(a);

    }
}