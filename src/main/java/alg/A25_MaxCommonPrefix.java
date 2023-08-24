package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author baojiang
 * @version �����ǰ׺: MaxCommonPrefix.java, v 0.1 2022��10��21�� ����7:48 baojiang Exp $
 */
public class A25_MaxCommonPrefix {

    public static void main(String[] args) throws IOException {
        String[] strs = { "zw", "zustomer", "car", "card", "cardsr", "12", "4a", "cards" };
        System.out.println(maxCommonPrefix(strs));

    }

    /**
     * �����ǰ׺
     * @param strs
     * @return
     */
    public static String maxCommonPrefix(String[] strs) {

        List<String[]> list = groupSort(strs);
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("����쳣!");
        }

        // ȡ��һ��Ԫ��,ע���ڲ��Ѿ��ź���
        String[] arr = list.get(0);

        //ѭ����������СԪ�س���,��Ϊ����Ԫ�ؿ϶�<��СԪ�س���
        int m = arr[0].length();
        int n = arr[arr.length - 1].length();
        int num = Math.min(m, n);

        // �Ƚϵ�һ�������һ��Ԫ��,��β��ͬ�м�϶���ͬ
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (arr[i].charAt(i) == arr[arr.length - 1].charAt(i)) {
                sb.append(arr[i].charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }

    /**
     * ����ǰ׺����,���Ҹ���Ԫ�س��Ƚ���
     * @param strs
     * @return
     */
    public static List<String[]> groupSort(String[] strs) {

        if (strs == null || strs.length == 0) {
            throw new IllegalArgumentException("���strsΪ��!");
        }

        // ���ַ��������Ԫ�ذ�����������(�������ֵĻ������ֻ�����ǰ��)
        Arrays.sort(strs);

        List<String[]> list = new ArrayList<>();
        // ����ָ��
        int slow = 0;
        int fast = 0;

        // ��ָ��û��Խ�������ұ߽�
        while (fast < strs.length) {
            // ��ָ�����ָ������һ��
            if (fast < strs.length - 1) {
                fast = slow + 1;
            }

            // ��һ���ַ����,���ָ������һ��,�����Ƚ�(���ܳ���ͬһԪ����Ƚ�����slow < fast)
            while (strs[slow].charAt(0) == strs[fast].charAt(0) && slow < fast) {
                fast++;
                // ��ָ�뵽�������ұ߽�,ֹͣ��ǰѭ��
                if (fast == strs.length) {
                    break;
                }
            }

            // ��������ĸ��ͬ��Ԫ�ص�������
            list.add(Arrays.copyOfRange(strs, slow, fast));
            slow = fast;

        }

        // ��list����Ԫ�س��Ƚ���
        Collections.sort(list, (o1, o2) -> o2.length - o1.length);

        return list;
    }

}