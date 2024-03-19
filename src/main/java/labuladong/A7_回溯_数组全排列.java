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
 * @version ����, ����ȫ����: A7_����_����ȫ����.java, v 0.1 2024��03��19�� 15:56  Baojiang Yang Exp $
 */
public class A7_����_����ȫ���� {

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
            //��ѡ��
            list.add(nums[i]);
            // ������һ�������
            dfs(nums, list, res);
            // ����ѡ��
            list.remove(list.size() - 1);
        }
    }


    /**------------------------------------------------------------------------------------------ */


    public static List<List<Integer>> res = Lists.newArrayList();

    public static List<List<Integer>> permute2(int[] nums) {

        // ��¼ ·��
        LinkedList<Integer> track = Lists.newLinkedList();
        //·���е�Ԫ�ػᱻ���Ϊtrue �����ظ�ʹ��
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }

    /**
     * ·��: ��¼��track��
     * ѡ���б�: nums�в�������track����ЩԪ��(used[i]Ϊfalse)
     * ��������: nums�е�Ԫ��ȫ����track�г���
     * @param nums
     * @param track
     * @param used
     */
    private static void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        //������������
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // �ų����Ϸ���ѡ��
            if (used[i]) {
                // nums[i]�Ѿ���track��,����
                continue;
            }

            // ��ѡ��
            track.add(nums[i]);
            used[i] = true;

            // ������һ�������
            backtrack(nums, track, used);

            // ����ѡ��
            track.removeLast();
            used[i] = false;
        }
    }

    //  д����������
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute1(nums));
        System.out.println(permute2(nums));
    }

}