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
 *  ���룺nums = [2,7,11,15], target = 9
 * �����[0,1]
 * ���ͣ���Ϊ nums[0] + nums[1] == 9 ������ [0, 1] ��
 *
 * @author baojiang
 * @version ����֮��: alg.A6_TwoSum.java, v 0.1 2022��10��01�� ����5:22 baojiang Exp $
 */
public class A6_TwoSum {

    public static void main(String[] args) {
        int nums[] = new int[] { 3, 4, 5, 4, 7, 8, 8, 1, 9 };
        int target = 12;
        PrintUtil.print(twoSum1(nums, target));
        PrintUtil.print(twoSum2(nums, target));
        PrintUtil.print(twoSum3(nums, target));
        System.out.println("�������������,��ȫ����");
        PrintUtil.printIntList(twoSum4(nums, target));
    }

    /**
     * ��������Ƕ��ѭ��
     * ʱ�临�Ӷȣ�O(n^2)
     * �ռ临�Ӷȣ�O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            // ���Բ���O(n)
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { nums[i], nums[j] };
                }
            }
        }

        return new int[0];
    }

    /**
     * ��ϣ��
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // ����Ԥ����
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // O(n)
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) { // O(n)
            int x = nums[i];
            // ��ϣ���� - O(1)
            if (map.containsKey(target - x)) {
                int index = map.get(target - x);
                // i �� index ����ͬһ��Ԫ�أ�ͬһ��Ԫ�ز���ʹ������
                if (i != index) {
                    return new int[] { nums[i], nums[index] };
                }
            }
        }

        return new int[0];

    }

    /**
     * ����+˫ָ��
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {

        // ����
        Arrays.sort(nums);

        // ����ָ��
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[low] + nums[high];
            // ����sum��target�Ƚ�,�ƶ�����ָ��
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
     * ����+˫ָ�� �������з���������Ԫ�ضԣ����в��ܳ����ظ�
     * @param nums
     * @param target
     * @return
     */
    public static List<int[]> twoSum4(int[] nums, int target) {

        // ����
        Arrays.sort(nums);

        List<int[]> res = new ArrayList<>();

        // ����ָ��
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low];
            int right = nums[high];
            // ����sum��target�Ƚ�,�ƶ�����ָ��
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