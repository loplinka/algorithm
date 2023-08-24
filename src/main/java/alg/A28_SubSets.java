package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * ����һ���������� nums�������е�Ԫ�ػ�����ͬ�����ظ��������п��ܵ��Ӽ����ݼ�����
 *
 * �⼯���ܰ����ظ����Ӽ�������԰�����˳�򷵻ؽ⼯��
 *
 * ���룺nums = [1,2,3]
 * �����[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 *
 * @author baojiang
 * @version �Ӽ�: alg.A28_SubSets.java, v 0.1 2022��10��23�� ����3:45 baojiang Exp $
 */
public class A28_SubSets {

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3 };

        PrintUtil.printList(subSets(arr));

    }

    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> subSets(int[] nums) {
        // ��¼·��
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, 0, track);
        return res;
    }

    public static void backTrack(int[] nums, int start, LinkedList<Integer> track) {

        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {

            // ��ѡ��
            track.add(nums[i]);
            // ����һ�²������
            backTrack(nums, i + 1, track);
            // ȡ��ѡ��
            track.removeLast();
        }
    }

}