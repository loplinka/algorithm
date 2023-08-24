package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author baojiang
 * @version 栈和队列: alg.A4_StackAndQueue.java, v 0.1 2022年09月28日 上午12:36 baojiang Exp $
 */
public class A4_StackAndQueue {

    public static void main(String[] args) {
        System.out.println(isValid2("((({[]})))"));
        System.out.println(isValid2("]})))}"));
        System.out.println(isValid2("(({[]})))"));
        System.out.println(isValid2("((({[]}))"));
    }

    /**
     * 判断是否是有效的括号
     * 匹配替换法,逻辑清晰,但是时间复杂度高
     * ((({[]})))
     */
    public static boolean isValid(String s) {
        // 字符去除空格,空字符等等异常判断先忽略
        int length;
        do {
            length = s.length();
            s = s.replace("{}", "").replace("[]", "").replace("()", "");
        } while (length != s.length());

        return s.length() == 0;
    }


    /**
     * 堆栈对配法
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        int n = s.length();
        // 奇数肯定不合法
        if (n % 2 == 1) {
            return false;
        }

        // 使用右括号作为key的巧妙之处在于可以用左括号来取值右括号,然后进行配对
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 右大中小括号作为key
            if (pairs.containsKey(ch)) {
                // 栈空 或者 栈顶元素不等于当前遍历元素key得到的value ==> 也就是可以配对
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                // 配对成功移除栈顶元素
                stack.pop();
            } else {
                // 压入栈顶
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }



}