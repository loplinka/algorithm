package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ���������� nums ���ж��Ƿ������Ԫ�� [nums[i], nums[j], nums[k]] ���� i != j��i != k �� j != k ��ͬʱ������ nums[i] + nums[j] + nums[k] == 0 ����
 *
 * �㷵�����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 *
 * ���룺nums = [-1,0,1,2,-1,-4]
 * �����[[-1,-1,2],[-1,0,1]]
 * ���ͣ�
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 ��
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 ��
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 ��
 * ��ͬ����Ԫ���� [-1,0,1] �� [-1,-1,2] ��
 * ע�⣬�����˳�����Ԫ���˳�򲢲���Ҫ��
 *
 * @author baojiang
 * @version ����֮��: alg.A6_ThreeSum.java, v 0.1 2022��10��01�� ����5:57 baojiang Exp $
 */
public class A6_ThreeSum {

    public static void main(String[] args) {
        int nums[] = new int[] { -1,0,1,2,-1,-4 };
        int target = 0;
        //ToolsClass.print(threeSum1(nums, target));
        threeSum(nums);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // ö�� a
        for (int first = 0; first < n; ++first) {
            // ��Ҫ����һ��ö�ٵ�������ͬ
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c ��Ӧ��ָ���ʼָ����������Ҷ�
            int third = n - 1;
            int target = -nums[first];
            // ö�� b ����λ����first + 1
            for (int second = first + 1; second < n; ++second) {
                // ��Ҫ����һ��ö�ٵ�������ͬ
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // ��Ҫ��֤ b ��ָ���� c ��ָ������
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // ���ָ���غϣ����� b ����������
                // �Ͳ��������� a+b+c=0 ���� b<c �� c �ˣ������˳�ѭ��
                if (second == third) {
                    break;
                }
                // ����֮��=0
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }




    /**
     * ����Ƕ��ѭ��
     * ���Ӷȣ�O(n^3)
     * @param nums
     * @param target
     * @return
     */
    public static int[] threeSum1(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length - 2; k++) {
                    if (nums[i] + nums[j]+ nums[k] == target) {
                        return new int[] { i, j, k};
                    }
                }

            }
        }

        return new int[0];
    }
}