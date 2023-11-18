/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

/**
 * @author Baojiang Yang
 * @version : A6_Str_子串和KPM.java, v 0.1 2023年11月18日 18:04  Baojiang Yang Exp $
 */
public class A6_Str_子串和KPM {

    /**
     * 定义字符串S= "BBC ABCDAB ABCDABCDABDE, 和子串P= ABCDABD
     * 查找P在S中的位置
     */

    static int vioMatch(String s, String p) {
        // 异常处理 TODO

        int sLength = s.length();
        int pLength = p.length();

        int i = 0;
        int j = 0;
        while (i < sLength && j < pLength) {

            // 匹配到,指针玩后移
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            // 未匹配到
            else {
                // i回溯到上次匹配的下一个位置,这里是关键
                i = i - j + 1;
                System.out.println(i);
                j = 0;
            }
        }

        if (j == pLength) {
            return i - j;
        }

        return -1;
    }


    static int findMinimumSubstring(String S, String p) {
        int n = S.length();
        int m = p.length();

        int minIndex = -1; // 初始化最小子串的起始位置为-1

        for (int i = 0; i <= n - m; i++) {
            String substring = S.substring(i, i + m); // 截取长度为m的子串
            if (substring.equals(p)) { // 子串与p匹配
                minIndex = i; // 更新最小子串的起始位置
                break; // 结束循环
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        String s = "CA";
        String p = "ABCDABD";
        System.out.println(vioMatch(s, p));
        System.out.println(findMinimumSubstring(s, p));
    }

}