package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

/**
 *
 * @author baojiang
 * @version 排序: alg.A7_Sort.java, v 0.1 2022年10月21日 下午8:20 baojiang Exp $
 */
public class A7_Sort {

    public static void main(String[] args) {
        int[] arr1 = new int[] { 6, 3, 7, 0, 1, 10, 5, 8 };
        PrintUtil.print(bubbleSort(arr1));

        int[] arr2 = new int[] { 6, 3, 7, 0, 1, 10, 5, 8 };
        PrintUtil.print(selectionSort(arr2));

        int[] arr3 = new int[] { 6, 3, 7, 0, 1, 10, 5, 8 };
        PrintUtil.print(insertionSort(arr3));

        int[] arr4 = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        quickSort(arr4, 0, arr4.length -1);
        PrintUtil.print(arr3);
    }

    /**
     * 冒泡排序
     *
     * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3.针对所有的元素重复以上的步骤，除了最后一个；
     * 4.重复步骤 1~3，直到排序完成。
     *
     * https://snailclimb.gitee.io/javaguide/#/docs/cs-basics/algorithms/10-classical-sorting-algorithms?id=%e5%86%92%e6%b3%a1%e6%8e%92%e5%ba%8f-bubble-sort
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }

            }
            if (flag) {
                break;
            }

        }

        return arr;
    }

    /**
     * 选择排序
     *
     * 1.首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 2.再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 3.重复第 2 步，直到所有元素均排序完毕。
     *
     * https://snailclimb.gitee.io/javaguide/#/docs/cs-basics/algorithms/10-classical-sorting-algorithms?id=%e9%80%89%e6%8b%a9%e6%8e%92%e5%ba%8f-selection-sort
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // 找出比minIndex还小的位置
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }

        }

        return arr;
    }

    /**
     * 插入排序
     * 1.从第一个元素开始，该元素可以认为已经被排序；
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4.重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5.将新元素插入到该位置后；
     * 6.重复步骤 2~5。
     * https://snailclimb.gitee.io/javaguide/#/docs/cs-basics/algorithms/10-classical-sorting-algorithms?id=%e6%8f%92%e5%85%a5%e6%8e%92%e5%ba%8f-insertion-sort
     * @param arr
     * @return arr
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex -= 1;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }


    /**
     * 快速排序
     *
     * 思路:
     * 1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
     *
     * 实现:
     * 1.选定一个基准值array[low]
     * 2.右指针从右向左遍历high--,查找笔基准值小的数据
     *   左指针从左向右遍历low++,查找笔基准值大的数据
     * 3.如果指针未相撞,交换左右两值位置,如果指针相遇,则替换基准值的位置
     * 4.左递归,右递归
     *
     * https://blog.csdn.net/weixin_39902962/article/details/123703648
     * https://blog.csdn.net/youzi_qiu7/article/details/107685339?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-107685339-blog-124094091.t0_edu_mix&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-107685339-blog-124094091.t0_edu_mix&utm_relevant_index=1
     * @param arr
     * @param low 待分区数组最小下标
     * @param high 待分区数组最大下标
     * @return
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找到基准元素的位置
            int pivotIndex = partition(arr, low, high);

            // 递归地对基准元素左右两边的子数组进行快速排序
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        // 选择最右边的元素作为基准
        int pivot = arr[high];
        int i = low - 1;

        // 将小于基准的元素移到基准的左边，大于等于基准的元素移到基准的右边
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // 将基准元素移到正确的位置
        swap(arr, i + 1, high);

        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}