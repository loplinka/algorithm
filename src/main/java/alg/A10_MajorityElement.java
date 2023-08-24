package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ����һ����СΪ n ������?nums ���������еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ����?? n/2 ??��Ԫ�ء�
 * ���ӣ�https://leetcode.cn/problems/majority-element
 * ���룺nums = [3,2,3]
 * �����3
 *
 * ���룺nums = [2,2,1,1,1,2,2]
 * �����2
 *
 * @author baojiang
 * @version ����Ԫ��: A10_Majority.java, v 0.1 2022��10��04�� ����2:41 baojiang Exp $
 */
public class A10_MajorityElement {

    public static void main(String[] args) {

        int[] nums = new int[] {2,2,1,1,1,2,2};
        System.out.println(Solution1.majorityElement(nums));
        System.out.println(Solution2.majorityElement(nums));
        System.out.println(Solution3.majorityElement(nums));

    }

    /**
     * ����һ����ϣ��
     */
    static class Solution1 {
        private static Map<Integer, Integer> countNums(int[] nums) {
            Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
            for (int num : nums) {
                if (!counts.containsKey(num)) {
                    counts.put(num, 1);
                } else {
                    counts.put(num, counts.get(num) + 1);
                }
            }
            return counts;
        }

        public static int majorityElement(int[] nums) {
            Map<Integer, Integer> counts = countNums(nums);

            Map.Entry<Integer, Integer> majorityEntry = null;
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                    majorityEntry = entry;
                }
            }

            return majorityEntry.getKey();
        }
    }

    /**
     * ������������
     */
    static class Solution2 {
        public static int majorityElement(int[] nums) {
            Arrays.sort(nums);
            // ��Ϊ����Ԫ����ָ�������г��ִ��� ����?? n/2 ??,���������϶�Խ����λ��
            return nums[nums.length / 2];
        }
    }


    static class Solution3 {
        private static int countInRange(int[] nums, int num, int lo, int hi) {
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

        private static int majorityElementRec(int[] nums, int lo, int hi) {
            // base case; the only element in an array of size 1 is the majority
            // element.
            if (lo == hi) {
                return nums[lo];
            }

            // recurse on left and right halves of this slice.
            int mid = (hi - lo) / 2 + lo;
            int left = majorityElementRec(nums, lo, mid);
            int right = majorityElementRec(nums, mid + 1, hi);

            // if the two halves agree on the majority element, return it.
            if (left == right) {
                return left;
            }

            // otherwise, count each element and return the "winner".
            int leftCount = countInRange(nums, left, lo, hi);
            int rightCount = countInRange(nums, right, lo, hi);

            return leftCount > rightCount ? left : right;
        }

        public static int majorityElement(int[] nums) {
            return majorityElementRec(nums, 0, nums.length - 1);
        }
    }


}