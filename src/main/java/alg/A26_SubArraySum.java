package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 *  给你一个整数数组nums和一个整数 k，请你统计并返回该数组中和为 k的连续子数组的个数。
 *
 * @author baojiang
 * @version 前缀和: A26_SubarraySum.java, v 0.1 2022年10月22日 下午5:59 baojiang Exp $
 */
public class A26_SubArraySum {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 1, 2, 2, 3, 1, 4, 5 };
        System.out.println(subArraySum1(arr, 4));
        System.out.println(subArraySum2(arr, 4));

    }


    public static int subArraySum1(int[] arr, int k) {

        if (arr.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;

        List<int[]> list = new ArrayList<>();

        while (slow < arr.length - 1) {
            fast = slow +1;
            while (fast < arr.length) {
                int[] subArr = Arrays.copyOfRange(arr, slow, fast);
                if (k == sum(subArr)) {
                    list.add(subArr);
                }
                fast++;
            }
            slow++;
        }


        return list.size();
    }



    public static int sum(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        return total;
    }


    public static int subArraySum2(int[] nums, int k) {
        int n = nums.length;
        // map：前缀和 -> 该前缀和出现的次数
        HashMap<Integer, Integer> preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);

        int res = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            // 这是我们想找的前缀和 nums[0..j]
            int sum0_j = sum0_i - k;
            // 如果前面有这个前缀和，则直接更新答案
            if (preSum.containsKey(sum0_j))
                res += preSum.get(sum0_j);
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }

}