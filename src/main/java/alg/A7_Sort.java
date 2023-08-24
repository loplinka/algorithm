package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.PrintUtil;

/**
 *
 * @author baojiang
 * @version ����: alg.A7_Sort.java, v 0.1 2022��10��21�� ����8:20 baojiang Exp $
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
     * ð������
     *
     * 1.�Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������
     * 2.��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԣ�����������Ԫ��Ӧ�û�����������
     * 3.������е�Ԫ���ظ����ϵĲ��裬�������һ����
     * 4.�ظ����� 1~3��ֱ��������ɡ�
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
     * ѡ������
     *
     * 1.������δ�����������ҵ���С����Ԫ�أ���ŵ��������е���ʼλ��
     * 2.�ٴ�ʣ��δ����Ԫ���м���Ѱ����С����Ԫ�أ�Ȼ��ŵ����������е�ĩβ��
     * 3.�ظ��� 2 ����ֱ������Ԫ�ؾ�������ϡ�
     *
     * https://snailclimb.gitee.io/javaguide/#/docs/cs-basics/algorithms/10-classical-sorting-algorithms?id=%e9%80%89%e6%8b%a9%e6%8e%92%e5%ba%8f-selection-sort
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // �ҳ���minIndex��С��λ��
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // ����
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }

        }

        return arr;
    }

    /**
     * ��������
     * 1.�ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
     * 2.ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ�裻
     * 3.�����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�ã�
     * 4.�ظ����� 3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�ã�
     * 5.����Ԫ�ز��뵽��λ�ú�
     * 6.�ظ����� 2~5��
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
     * ��������
     *
     * ˼·:
     * 1���ȴ�������ȡ��һ������Ϊ��׼����
     * 2���������̣���������������ȫ�ŵ������ұߣ�С�ڻ����������ȫ�ŵ�������ߡ�
     * 3���ٶ����������ظ��ڶ�����ֱ��������ֻ��һ������
     *
     * ʵ��:
     * 1.ѡ��һ����׼ֵarray[low]
     * 2.��ָ������������high--,���ұʻ�׼ֵС������
     *   ��ָ��������ұ���low++,���ұʻ�׼ֵ�������
     * 3.���ָ��δ��ײ,����������ֵλ��,���ָ������,���滻��׼ֵ��λ��
     * 4.��ݹ�,�ҵݹ�
     *
     * https://blog.csdn.net/weixin_39902962/article/details/123703648
     * https://blog.csdn.net/youzi_qiu7/article/details/107685339?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-107685339-blog-124094091.t0_edu_mix&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-107685339-blog-124094091.t0_edu_mix&utm_relevant_index=1
     * @param array
     * @param low ������������С�±�
     * @param high ��������������±�
     * @return
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int position = partition(array, low, high);
            quickSort(array, low, position - 1);
            quickSort(array, position + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            //System.out.println(Arrays.toString(array));
        }
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }

}