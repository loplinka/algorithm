package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * �����㷨���
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&scene=21#wechat_redirect
 *
 * @author baojiang
 * @version ���ݷ�: alg.A27_BackTrack.java, v 0.1 2022��10��23�� ����1:43 baojiang Exp $
 */
public class A27_BackTrack {

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3 };

        PrintUtil.printList(Solution.permute(arr));

    }

    /**
     * ���ݷ����ȫ��������
     */
    static class Solution {

        public static List<List<Integer>> res = new LinkedList<>();

        public static List<List<Integer>> permute(int[] nums) {
            // ��¼·��
            LinkedList<Integer> track = new LinkedList<>();
            backTrack(nums, track);
            return res;
        }

        /**
         * ����ľ��� for ѭ������ĵݹ飬�ڵݹ����֮ǰ����ѡ�񡹣��ڵݹ����֮�󡸳���ѡ�񡹣�
         * @param nums
         * @param track
         */
        public static void backTrack(int[] nums, LinkedList<Integer> track) {

            // ������������
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // �ų����Ϸ���ѡ��
                if (track.contains(nums[i])) {
                    continue;
                }
                // ��ѡ��
                track.add(nums[i]);
                // ����һ�²������
                backTrack(nums, track);
                // ȡ��ѡ��
                track.removeLast();
            }

        }

    }

}