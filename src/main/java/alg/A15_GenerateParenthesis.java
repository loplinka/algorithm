package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� �������
 *  ʾ�� 1��
 *
 * ���룺n = 3
 * �����["((()))","(()())","(())()","()(())","()()()"]
 * ʾ�� 2��
 *
 * ���룺n = 1
 * �����["()"]
 *
 * ���ӣ�https://leetcode.cn/problems/generate-parentheses
 *
 *
 * @author baojiang
 * @version �������п��ܵ��������: alg.A15_GenerateParenthesis.java, v 0.1 2022��10��05�� ����4:09 baojiang Exp $
 */
public class A15_GenerateParenthesis {

    public static void main(String[] args) {



        String[] arr = new String[] { ")", ")", ")", "(", "(", "(" };

        //char[] invalidateStr = new char[] { '(', ')', ')', ')', '(', '(' };
        //char[] validateStr = new char[] { '(', '(', '(', ')', ')', ')' };
        List<String> result  = new ArrayList<String>();
        //Solution1.gen(new char[3], 0,  result);
        //System.out.println(result);
        //Solution1.valid2(validateStr);

        // ToolsClass.printStr(Solution1.generateParenthesis(3));

        PrintUtil.printStr(Solution2.generateParenthesis(3));
        PrintUtil.printStr(Solution1.generateParenthesis(3));

    }

    /**
     * �����������ݷ�
     * ֻ��������Ȼ������Чʱ�����(����)���������� ����һ ����ÿ����ӡ�
     * ���ǿ���ͨ�����ٵ�ĿǰΪֹ���õ������ź������ŵ���Ŀ��������һ�㣬
     * ������������������� nn�����ǿ��Է�һ�������š��������������С�������ŵ����������ǿ��Է�һ�������š�
     *
     */
    static class Solution2 {

        public static List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<String>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            // ����Ϊ2nʱ�˳�
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            // �����Ż�С������ֵ(����n=3,�������������3��),���Լ������
            if (open < max) {
                cur.append('(');// ��ѡ��
                backtrack(ans, cur, open + 1, close, max);// ���ݽ�����һ�������
                cur.deleteCharAt(cur.length() - 1);// ����ѡ��
            }
            // ������ͬ��
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }



    }

    /**
     * ����һ: ������
     * 1.�������� 2^2n�� `(' �� `) �ַ����ɵ����У�Ȼ�����Ǽ��ÿһ���Ƿ���Ч����
     * 2.Ϊ�������������У����ǿ���ʹ�õݹ顣����Ϊ nn �����о����ڳ���Ϊ n - 1n?1 ������ǰ��һ��"("��")"
     */
    static class Solution1 {

        public static List<String> generateParenthesis(int n) {
            List<String> combinations = new ArrayList<String>();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
        }

        /**
         * �������п��ܵ����
         * @param current
         * @param pos
         * @param result
         */
        public static void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                current[pos] = '(';
                generateAll(current, pos + 1, result);
                current[pos] = ')';
                generateAll(current, pos + 1, result);
            }
        }

        /**
         * ��ס:
         * 1�εݹ����ֻ��õ�(((
         * 2�εݹ������Ϊ��)�Ĳ���,��õ��������Ź̶����ȵ������������
         *
         * @param array
         * @param index
         * @param result
         */
        public static void gen(char[] array, int index, List<String> result) {
            if (index == array.length) {
                result.add(Arrays.toString(array));
            } else {
                array[index] = '(' ;
                gen(array, index + 1, result);
                array[index] = ')';
                gen(array, index + 1, result);
            }
        }

        /**
         * ��֤���ŵ���Ч��,balance++����--��, O(n)
         * @param current
         * @return
         */
        public static boolean valid(char[] current) {
            // 1.����ǺϷ�����,������������һ�����,����һ���������ſ�ͷ
            // 2.�����������n��������,һ��������ų��ֶ�Ӧ����n��������,balance��+��-����Ϊ��ά�����ƽ��
            int balance = 0;
            for (char c : current) {
                if (c == '(') {
                    ++balance;
                } else {
                    --balance;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }

        /**
         *  ��֤���ŵ���Ч��,ƥ���滻��,ʱ�临�Ӷ���һ������,log(N)
         * @param current
         * @return
         */
        public static boolean valid2(char[] current) {
            String str = new String(current);
            int length;
            do {
                length = str.length();
                str = str.replace("()", "");
            } while (length != str.length());

            return str.length() == 0;
        }

        /**
         * ��֤���ŵ���Ч��,����+Stack��,ʱ�临�Ӷ�O(n),�ռ临�Ӷȶ��⿪����һ������,Ҳ��������
         */


    }

}