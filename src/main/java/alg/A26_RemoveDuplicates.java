package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给你一个有序数组arr，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后新数组。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成
 *
 * @author baojiang
 * @version 移除重复元素: A26.java, v 0.1 2022年10月22日 下午4:01 baojiang Exp $
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