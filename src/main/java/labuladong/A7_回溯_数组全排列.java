/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package labuladong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 *
 * @author Baojiang Yang
 * @version 回溯, 数组全排列: A7_回溯_数组全排列.java, v 0.1 2024年03月19日 15:56  Baojiang Yang Exp $
 */
public class A7_回溯_数组全排列 {

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = Lists.newArrayList();
        List<Integer> list = Lists.newArrayList();
        dfs(nums, list, res);
        return res;
    }

    private static void dfs(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            //做选择
            list.add(nums[i]);
            // 进入下一层决策树
            dfs(nums, list, res);
            // 撤销选择
            list.remove(list.size() - 1);
        }
    }


    /**------------------------------------------------------------------------------------------ */


    public static List<List<Integer>> res = Lists.newArrayList();

    public static List<List<Integer>> permute2(int[] nums) {

        // 记录 路径
        LinkedList<Integer> track = Lists.newLinkedList();
        //路径中的元素会被标记为true 避免重复使用
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }

    /**
     * 路径: 记录在track中
     * 选择列表: nums中不存在于track的哪些元素(used[i]为false)
     * 结束条件: nums中的元素全部在track中出现
     * @param nums
     * @param track
     * @param used
     */
    private static void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        //触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {
                // nums[i]已经在track中,跳过
                continue;
            }

            // 做选择
            track.add(nums[i]);
            used[i] = true;

            // 进入下一层决策树
            backtrack(nums, track, used);

            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }

    //  写出测试用例
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute1(nums));
        System.out.println(permute2(nums));
    }

}