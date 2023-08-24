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
 * @version ջ�Ͷ���: alg.A4_StackAndQueue.java, v 0.1 2022��09��28�� ����12:36 baojiang Exp $
 */
public class A4_StackAndQueue {

    public static void main(String[] args) {
        System.out.println(isValid2("((({[]})))"));
        System.out.println(isValid2("]})))}"));
        System.out.println(isValid2("(({[]})))"));
        System.out.println(isValid2("((({[]}))"));
    }

    /**
     * �ж��Ƿ�����Ч������
     * ƥ���滻��,�߼�����,����ʱ�临�Ӷȸ�
     * ((({[]})))
     */
    public static boolean isValid(String s) {
        // �ַ�ȥ���ո�,���ַ��ȵ��쳣�ж��Ⱥ���
        int length;
        do {
            length = s.length();
            s = s.replace("{}", "").replace("[]", "").replace("()", "");
        } while (length != s.length());

        return s.length() == 0;
    }


    /**
     * ��ջ���䷨
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        int n = s.length();
        // �����϶����Ϸ�
        if (n % 2 == 1) {
            return false;
        }

        // ʹ����������Ϊkey������֮�����ڿ�������������ȡֵ������,Ȼ��������
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // �Ҵ���С������Ϊkey
            if (pairs.containsKey(ch)) {
                // ջ�� ���� ջ��Ԫ�ز����ڵ�ǰ����Ԫ��key�õ���value ==> Ҳ���ǿ������
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                // ��Գɹ��Ƴ�ջ��Ԫ��
                stack.pop();
            } else {
                // ѹ��ջ��
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }



}