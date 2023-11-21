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

    /**
     * 暴力搜索法
     * @param s
     * @param p
     * @return
     */
    static int vioSearch(String s, String p) {
        // 异常处理 TODO

        int sLength = s.length();
        int pLength = p.length();

        int i = 0;
        int j = 0;
        while (i < sLength && j < pLength) {

            // 匹配到,指针一起往后移
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            // 未匹配到
            else {
                // 当子串到了后边匹配失败时,主串的指针要退回上一次匹配的下一个位置,即要逐步走,称为回溯
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == pLength) {
            return i - j;
        }

        return -1;
    }



    /**
     * 使用了函数,无法提现出双指针操作
     * @param s
     * @param p
     * @return
     */
    static int funSearch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int minIndex = -1; // 初始化最小子串的起始位置为-1

        for (int i = 0; i <= n - m; i++) {
            String substring = s.substring(i, i + m); // 截取长度为m的子串
            if (substring.equals(p)) { // 子串与p匹配
                minIndex = i; // 更新最小子串的起始位置
                break; // 结束循环
            }
        }

        return minIndex;
    }

    /**
     * KPM算法查找子串
     */
    static int kpmSearch(String S, String p) {
        int n = S.length();
        int m = p.length();

        int[] lps = computeLPSArray(p); // 计算子串p的最长前缀后缀数组

        int i = 0; // 指向S的索引
        int j = 0; // 指向p的索引

        while (i < n) {
            if (S.charAt(i) == p.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    return i - j; // 返回匹配子串的起始位置
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // 部分匹配，更新j为最长前缀后缀长度
                } else {
                    i++;
                }
            }
        }

        return -1; // 未找到匹配子串，返回-1
    }

    private static int[] computeLPSArray(String p) {
        int m = p.length();

        int[] lps = new int[m];
        lps[0] = 0;

        int len = 0;
        int i = 1;

        while (i < m) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";
        System.out.println(vioSearch(s, p));
        System.out.println(funSearch(s, p));
        System.out.println(kpmSearch(s, p));
    }

    /**
     * 自主练习
     * @param s
     * @param p
     * @return
     */
    static int vodSearchByMyself(String s, String p) {
        // 异常处理

        int sLen = s.length();
        int pLen = p.length();

        int i = 0;
        int j = 0;
        while (i < sLen && j < pLen) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == pLen) {
            return i - j;
        }

        return -1;
    }

}