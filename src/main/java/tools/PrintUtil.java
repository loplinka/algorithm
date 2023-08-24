/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package tools;

import base.ListNode;
import base.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * @author baojiang
 * @version ���߷���: ToolsClass.java, v 0.1 2022��10��01�� ����5:43 baojiang Exp $
 */
public class PrintUtil {


    public static void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.println(temp.getVal());
            temp = temp.next;
        }
    }

    /**
     *
     * @param nums
     */
    public static void print(int[] nums) {
        if (nums.length == 0) {
            System.out.println("����Ϊ��!");
            return;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void printIntList(List<int[]> list) {
        if (list == null || list.size() == 0) {
            System.out.println("����Ϊ��!");
            return;
        }

        for (int[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     *
     * @param list
     */
    public static void print(Set<Integer> list) {
        if (list == null || list.size() == 0) {
            System.out.println("����Ϊ��!");
            return;
        }

        StringBuffer sb = new StringBuffer();
        for (Integer ele : list) {
            sb.append(ele.intValue()).append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    /**
     *
     * @param list
     */
    public static void print(List<Integer> list) {
        if (list == null || list.size() == 0) {
            System.out.println("����Ϊ��!");
            return;
        }

        StringBuffer sb = new StringBuffer();
        for (Integer ele : list) {
            sb.append(ele.intValue()).append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static void print(TreeNode node) {
        System.out.println(node != null ? node.val : "����Ϊ��!");
    }

    public static void printList(List<List<Integer>> list) {
        if (list == null || list.size() == 0) {
            System.out.println("����Ϊ��!");
            return;
        }

        StringBuffer sb = new StringBuffer();
        for (List<Integer> eles : list) {
            sb.append("[");
            for (Integer ele : eles) {
                sb.append(ele.intValue()).append(",");
            }
            if (eles.size() !=0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]");
        }

        System.out.println(sb.toString());
    }

    /**
     *
     * @param list
     */
    public static void printStr(List<String> list) {
        if (list == null || list.size() == 0) {
            System.out.println("����Ϊ��!");
            return;
        }

        StringBuffer sb = new StringBuffer();
        for (String ele : list) {
            sb.append(ele).append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

}