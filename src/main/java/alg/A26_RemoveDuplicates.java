package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * ����һ����������arr������ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹÿ��Ԫ��ֻ����һ�Σ�����ɾ���������顣
 *
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ��O(1)����ռ�����������
 *
 * @author baojiang
 * @version �Ƴ��ظ�Ԫ��: A26.java, v 0.1 2022��10��22�� ����4:01 baojiang Exp $
 */
public class A26_RemoveDuplicates {

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 1, 2, 2, 3, 4, 5, 1 };
        PrintUtil.print(arr);
        PrintUtil.print(removeDuplicates(arr));

    }

    public static int[] removeDuplicates(int[] arr) {

        if (arr.length == 0) {
            return arr;
        }

        int slow = 0;
        int fast;

        while (slow < arr.length - 1) {
            fast = slow + 1;
            while (fast < arr.length) {
                if (slow < fast && arr[fast] == arr[slow] && arr[slow] != -1) {
                    arr[fast] = -1;
                }
                fast++;
            }
            slow++;
        }

        List<Integer> list = new ArrayList<>();
        for (int ele : arr) {
            if (ele != -1) {
                list.add(ele);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}