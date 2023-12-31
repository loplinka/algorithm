package alg;

/**
* Alipay.com Inc.
* Copyright (c) 2004-2022 All Rights Reserved.
*/

import java.util.*;

/**
 *
 * @author baojiang
 * @version 二分查找: alg.A18_BinarySearch.java, v 0.1 2022年10月08日 下午3:37 baojiang Exp $
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
     * 二分查找,迭代法
     * @param arr
     * @param key
     * @return
     */
    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        // 目标超左边界, 目标超右边界, 慢指针超过快指针
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            // 比关键字大则在左边
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        // key不在数组中
        return -1;
    }

    /**
     * 二分查找,递归法
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
        // 目标超左边界, 目标超右边界, 慢指针超过快指针
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        int middle = (low + high) / 2;
        //比关键字大则关键字在左区域,则high的位置左移到middle -1
        if (arr[middle] > key) {
            return recursionBinarySearch(arr, key, low, middle - 1);
        }
        //比关键字小则关键字在右区域,则low的位置右移到middle+1
        else if (arr[middle] < key) {
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }

    }

    /**
     * 自主练习
     * @param arr
     * @param key
     * @return
     */
    public static int commonBinarySearchMyself(int[] arr, int key) {

        // 底位指针
        int low = 0;
        // 高位指针
        int high = arr.length - 1;
        // 中位指针
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

    public boolean isIn(int[][] arr, int target) {
        for (int row = 0; row < arr[0].length; row++) {
            if (binSearch(arr[row], target)) {
                return true;
            }
        }

        return false;
    }

    public boolean binSearch(int[] arr, int target) {
        if (arr == null) {
            return false;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;

        if (arr[left] > target || arr[right] < target || left > right) {
            return false;
        }

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] >= target) {
                left = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    /**
     * 二位数据中是否存在指定的target元素
     * @param arr
     * @param target
     * @return
     */
    public static boolean isContains(int[][] arr, int target) {
        if (arr == null) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            boolean found = binSearch2(arr[i], target);
            if (found) {
                return true;
            }
        }

        return false;
    }

    public static boolean binSearch2(int[] arr, int target) {
        if (arr == null) {
            return false;
        }

        int left = 0;
        int right = arr.length - 1;

        // 异常情况
        if (arr[left] > target || arr[right] < target || left > right) {
            return false;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            // 找到
            if (arr[mid] == target) {
                return true;
            }
            // 在左边,指针左移动
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            // 在右边,指针右移动
            else {
                left = mid + 1;
            }
        }

        return false;
    }

}