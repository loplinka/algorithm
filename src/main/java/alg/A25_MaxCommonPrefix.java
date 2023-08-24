package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author baojiang
 * @version 最长公共前缀: MaxCommonPrefix.java, v 0.1 2022年10月21日 下午7:48 baojiang Exp $
 */
public class A25_MaxCommonPrefix {

    public static void main(String[] args) throws IOException {
        String[] strs = { "zw", "zustomer", "car", "card", "cardsr", "12", "4a", "cards" };
        System.out.println(maxCommonPrefix(strs));

    }

    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public static String maxCommonPrefix(String[] strs) {

        List<String[]> list = groupSort(strs);
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("入参异常!");
        }

        // 取第一组元素,注意内部已经排好序
        String[] arr = list.get(0);

        //循环次数是最小元素长度,因为公共元素肯定<最小元素长度
        int m = arr[0].length();
        int n = arr[arr.length - 1].length();
        int num = Math.min(m, n);

        // 比较第一个和最后一个元素,收尾相同中间肯定相同
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (arr[i].charAt(i) == arr[arr.length - 1].charAt(i)) {
                sb.append(arr[i].charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }

    /**
     * 按照前缀分组,并且根据元素长度降序
     * @param strs
     * @return
     */
    public static List<String[]> groupSort(String[] strs) {

        if (strs == null || strs.length == 0) {
            throw new IllegalArgumentException("入参strs为空!");
        }

        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(strs);

        List<String[]> list = new ArrayList<>();
        // 快慢指针
        int slow = 0;
        int fast = 0;

        // 快指针没有越过数组右边界
        while (fast < strs.length) {
            // 快指针比慢指针先走一步
            if (fast < strs.length - 1) {
                fast = slow + 1;
            }

            // 第一个字符相等,则快指针再走一步,继续比较(不能出现同一元素相比较所以slow < fast)
            while (strs[slow].charAt(0) == strs[fast].charAt(0) && slow < fast) {
                fast++;
                // 快指针到达数组右边界,停止当前循环
                if (fast == strs.length) {
                    break;
                }
            }

            // 复制首字母相同的元素到新数组
            list.add(Arrays.copyOfRange(strs, slow, fast));
            slow = fast;

        }

        // 给list按照元素长度降序
        Collections.sort(list, (o1, o2) -> o2.length - o1.length);

        return list;
    }

}