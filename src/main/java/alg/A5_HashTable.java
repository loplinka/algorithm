package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author baojiang
 * @version ��ϣ��: alg.A5_HashTable.java, v 0.1 2022��10��01�� ����4:58 baojiang Exp $
 */
public class A5_HashTable {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<Integer>();
        ts.add(1);
        ts.add(6);
        ts.add(2);
        ts.add(-1);
        ts.add(5);
        ts.add(0);

        System.out.println(ts.first());
        System.out.println(ts.last());
        System.out.println(ts.size());
        System.out.println(ts.remove(6));


    }

    /**
     * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
     * ����: s = "anagram", t = "nagaram"
     * ���: true
     * ����: s = "rat", t = "car"
     * ���: false
     */

    /**
     * ����ȽϷ�,���Ӷ��� O(N*logN)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * ӳ�䷨ O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }


}