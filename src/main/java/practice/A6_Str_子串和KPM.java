/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

/**
 * @author Baojiang Yang
 * @version : A6_Str_�Ӵ���KPM.java, v 0.1 2023��11��18�� 18:04  Baojiang Yang Exp $
 */
public class A6_Str_�Ӵ���KPM {

    /**
     * �����ַ���S= "BBC ABCDAB ABCDABCDABDE, ���Ӵ�P= ABCDABD
     * ����P��S�е�λ��
     */

    static int vioMatch(String s, String p) {
        // �쳣���� TODO

        int sLength = s.length();
        int pLength = p.length();

        int i = 0;
        int j = 0;
        while (i < sLength && j < pLength) {

            // ƥ�䵽,ָ�������
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            // δƥ�䵽
            else {
                // i���ݵ��ϴ�ƥ�����һ��λ��,�����ǹؼ�
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

        int minIndex = -1; // ��ʼ����С�Ӵ�����ʼλ��Ϊ-1

        for (int i = 0; i <= n - m; i++) {
            String substring = S.substring(i, i + m); // ��ȡ����Ϊm���Ӵ�
            if (substring.equals(p)) { // �Ӵ���pƥ��
                minIndex = i; // ������С�Ӵ�����ʼλ��
                break; // ����ѭ��
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