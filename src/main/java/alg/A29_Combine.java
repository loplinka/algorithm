package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * ������������n��k�����ط�Χ[1, n]�����п��ܵ�k��������ϡ�����԰��κ�˳�򷵻ش𰸡�
 *
 * ���룺n = 4, k = 2
 * �����
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 *
 * @author baojiang
 * @version ���: A29_combination.java, v 0.1 2022��10��23�� ����4:11 baojiang Exp $
 */
public class A29_Combine {

    public static void main(String[] args) {

        int n = 4;
        int k = 2;
        PrintUtil.printList(combine(n, k));

    }

    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {

        // ��¼·��
        LinkedList<Integer> track = new LinkedList<>();
        if (n <= 0 || k <= 0) {
            return new LinkedList<>();
        }
        backTrack(n, k, 1, track);
        return res;
    }

    public static void backTrack(int n, int k, int start, LinkedList<Integer> track) {

        // �������ĵײ�, ������������
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        // ע�� i �� start ��ʼ����
        for (int i = start; i <= n; i++) {
            // ��ѡ��
            track.add(i);
            // ����һ�²������
            backTrack(n, k, i + 1, track);
            // ȡ��ѡ��
            track.removeLast();
        }

    }

}