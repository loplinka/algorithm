package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */


import java.util.*;

/**
 *
 * @author baojiang
 * @version ���ֲ���: alg.A18_BinarySearch.java, v 0.1 2022��10��08�� ����3:37 baojiang Exp $
 */
public class A18_BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int key = 3;
        System.out.println(commonBinarySearch(arr, key));
        System.out.println(recursionBinarySearch(arr, key));
        System.out.println(commonBinarySearchMyself(arr, key));

    }

    /**
     * ���ֲ���,������
     * @param arr
     * @param key
     * @return
     */
    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        // Ŀ�곬��߽�, Ŀ�곬�ұ߽�, ��ָ�볬����ָ��
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            // �ȹؼ��ִ��������
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        // key����������
        return -1;
    }

    /**
     * ���ֲ���,�ݹ鷨
     * @param arr
     * @param key
     * @return
     */
    public static int recursionBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        return recursionBinarySearch(arr, key, low, high);
    }

    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {
        // Ŀ�곬��߽�, Ŀ�곬�ұ߽�, ��ָ�볬����ָ��
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        int middle = (low + high) / 2;
        //�ȹؼ��ִ���ؼ�����������,��high��λ�����Ƶ�middle -1
        if (arr[middle] > key) {
            return recursionBinarySearch(arr, key, low, middle - 1);
        }
        //�ȹؼ���С��ؼ�����������,��low��λ�����Ƶ�middle+1
        else if (arr[middle] < key) {
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }

    }

    /**
     * ������ϰ
     * @param arr
     * @param key
     * @return
     */
    public static int commonBinarySearchMyself(int[] arr, int key) {

        // ��λָ��
        int low = 0;
        // ��λָ��
        int high = arr.length - 1;
        // ��λָ��
        int middle;

        if (arr[low] > key || arr[high] < key || low > high) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }

        }

        return -1;
    }
}