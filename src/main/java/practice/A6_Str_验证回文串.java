/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

/**
 * @author Baojiang Yang
 * @version : A6_Str_��������.java, v 0.1 2023��11��18�� 20:31  Baojiang Yang Exp $
 */
public class A6_Str_��֤���Ĵ� {


    /**
     *
     * ��������Ƚ�
     */
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuffer sgood = new StringBuffer();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    sgood.append(Character.toLowerCase(ch));
                }
            }
            StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
            return sgood.toString().equals(sgood_rev.toString());
        }
    }

    /**
     * ˫ָ��
     */
    class Solution1 {
        public boolean isPalindrome(String s) {
            StringBuffer sgood = new StringBuffer();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    sgood.append(Character.toLowerCase(ch));
                }
            }
            int n = sgood.length();
            int left = 0, right = n - 1;
            while (left < right) {
                if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
            return true;
        }
    }








}