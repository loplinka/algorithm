package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给你一个整数数组 nums，数组中的元素互不相同，返回该数组所有可能的子集（幂集）。
 *
 * 解集不能包含重复的子集。你可以按任意顺序返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 *
 * @author baojiang
 * @version 子集: alg.A28_SubSets.java, v 0.1 2022年10月23日 下午3:45 baojiang Exp $
 */
public class A28_SubSets {

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3 };

        PrintUtil.printList(subSets(arr));

    }

    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> subSets(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, 0, track);
        return res;
    }

    public static void backTrack(int[] nums, int start, LinkedList<Integer> track) {

        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {

            // 做选择
            track.add(nums[i]);
            // 进入一下层决策树
            backTrack(nums, i + 1, track);
            // 取消选择
            track.removeLast();
        }
    }

}