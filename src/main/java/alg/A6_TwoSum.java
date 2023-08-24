package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 *  输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * @author baojiang
 * @version 两数之和: alg.A6_TwoSum.java, v 0.1 2022年10月01日 下午5:22 baojiang Exp $
 */
public class A6_TwoSum {

    public static void main(String[] args) {
        int nums[] = new int[] { 3, 4, 5, 4, 7, 8, 8, 1, 9 };
        int target = 12;
        PrintUtil.print(twoSum1(nums, target));
        PrintUtil.print(twoSum2(nums, target));
        PrintUtil.print(twoSum3(nums, target));
        System.out.println("以下是所有组合,即全排列");
        PrintUtil.printIntList(twoSum4(nums, target));
    }

    /**
     * 暴力两层嵌套循环
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            // 线性查找O(n)
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { nums[i], nums[j] };
                }
            }
        }

        return new int[0];
    }

    /**
     * 哈希法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // 数据预处理
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // O(n)
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) { // O(n)
            int x = nums[i];
            // 哈希查找 - O(1)
            if (map.containsKey(target - x)) {
                int index = map.get(target - x);
                // i 和 index 不是同一个元素，同一个元素不能使用两次
                if (i != index) {
                    return new int[] { nums[i], nums[index] };
                }
            }
        }

        return new int[0];

    }

    /**
     * 排序+双指针
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {

        // 排序
        Arrays.sort(nums);

        // 左右指针
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[low] + nums[high];
            // 根军sum和target比较,移动左右指针
            if (sum < target) {
                low++;
            } else if (sum > target) {
                high--;
            } else if (sum == target) {
                return new int[] { nums[low], nums[high] };
            }
        }
        return new int[] {};
    }

    /**
     * 排序+双指针 返回所有符合条件的元素对，其中不能出现重复
     * @param nums
     * @param target
     * @return
     */
    public static List<int[]> twoSum4(int[] nums, int target) {

        // 排序
        Arrays.sort(nums);

        List<int[]> res = new ArrayList<>();

        // 左右指针
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low];
            int right = nums[high];
            // 根军sum和target比较,移动左右指针
            if (sum < target) {
                while (low < high && nums[low] == left) {
                    low++;
                }
            } else if (sum > target) {
                while (low < high && nums[high] == right) {
                    high--;
                }
            } else if (sum == target) {
                res.add(new int[] { nums[low], nums[high] });
                while (low < high && nums[low] == left) {
                    low++;
                }
                while (low < high && nums[high] == right) {
                    high--;
                }
            }
        }
        return res;
    }

}