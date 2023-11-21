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

    /**
     * ����������
     * @param s
     * @param p
     * @return
     */
    static int vioSearch(String s, String p) {
        // �쳣���� TODO

        int sLength = s.length();
        int pLength = p.length();

        int i = 0;
        int j = 0;
        while (i < sLength && j < pLength) {

            // ƥ�䵽,ָ��һ��������
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            // δƥ�䵽
            else {
                // ���Ӵ����˺��ƥ��ʧ��ʱ,������ָ��Ҫ�˻���һ��ƥ�����һ��λ��,��Ҫ����,��Ϊ����
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
     * ʹ���˺���,�޷����ֳ�˫ָ�����
     * @param s
     * @param p
     * @return
     */
    static int funSearch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int minIndex = -1; // ��ʼ����С�Ӵ�����ʼλ��Ϊ-1

        for (int i = 0; i <= n - m; i++) {
            String substring = s.substring(i, i + m); // ��ȡ����Ϊm���Ӵ�
            if (substring.equals(p)) { // �Ӵ���pƥ��
                minIndex = i; // ������С�Ӵ�����ʼλ��
                break; // ����ѭ��
            }
        }

        return minIndex;
    }

    /**
     * KPM�㷨�����Ӵ�
     */
    static int kpmSearch(String S, String p) {
        int n = S.length();
        int m = p.length();

        int[] lps = computeLPSArray(p); // �����Ӵ�p���ǰ׺��׺����

        int i = 0; // ָ��S������
        int j = 0; // ָ��p������

        while (i < n) {
            if (S.charAt(i) == p.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    return i - j; // ����ƥ���Ӵ�����ʼλ��
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // ����ƥ�䣬����jΪ�ǰ׺��׺����
                } else {
                    i++;
                }
            }
        }

        return -1; // δ�ҵ�ƥ���Ӵ�������-1
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
     * ������ϰ
     * @param s
     * @param p
     * @return
     */
    static int vodSearchByMyself(String s, String p) {
        // �쳣����

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