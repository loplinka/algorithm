package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 *  示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 链接：https://leetcode.cn/problems/generate-parentheses
 *
 *
 * @author baojiang
 * @version 生产所有可能的括号组合: alg.A15_GenerateParenthesis.java, v 0.1 2022年10月05日 下午4:09 baojiang Exp $
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
     * 方法二：回溯法
     * 只在序列仍然保持有效时才添加(或者)，而不是像 方法一 那样每次添加。
     * 我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     * 如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
     *
     */
    static class Solution2 {

        public static List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<String>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            // 长度为2n时退出
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            // 左括号还小于上限值(比如n=3,则最多左括号有3个),可以继续添加
            if (open < max) {
                cur.append('(');// 做选择
                backtrack(ans, cur, open + 1, close, max);// 回溯进入下一层决策树
                cur.deleteCharAt(cur.length() - 1);// 撤销选择
            }
            // 右括号同理
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }



    }

    /**
     * 方法一: 暴力法
     * 1.生成所有 2^2n个 `(' 和 `) 字符构成的序列，然后我们检查每一个是否有效即可
     * 2.为了生成所有序列，我们可以使用递归。长度为 nn 的序列就是在长度为 n - 1n?1 的序列前加一个"("和")"
     */
    static class Solution1 {

        public static List<String> generateParenthesis(int n) {
            List<String> combinations = new ArrayList<String>();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
        }

        /**
         * 生成所有可能的组合
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
         * 记住:
         * 1次递归调用只会得到(((
         * 2次递归调用因为有)的参与,会得到左右括号固定长度的所有排列组合
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
         * 验证括号的有效性,balance++或者--法, O(n)
         * @param current
         * @return
         */
        public static boolean valid(char[] current) {
            // 1.如果是合法括号,左右括号数量一定相等,而且一定是左括号开头
            // 2.如果连续出现n个左括号,一定会紧接着出现对应数量n的右括号,balance先+后-就是为了维持这个平衡
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
         *  验证括号的有效性,匹配替换法,时间复杂度有一个查找,log(N)
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
         * 验证括号的有效性,迭代+Stack法,时间复杂度O(n),空间复杂度额外开辟了一个队列,也不是最优
         */


    }

}