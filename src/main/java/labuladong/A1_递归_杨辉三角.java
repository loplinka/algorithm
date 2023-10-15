/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Baojiang Yang
 * @version : A1_递归_杨辉三角.java, v 0.1 2023年09月19日 01:01  Baojiang Yang Exp $
 */
public class A1_递归_杨辉三角 {

    /**
     * 给一个杨辉三角,并且给一个rowIndex,求出这一行的所有元素
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curRow = new ArrayList<>();
        // 每一行的开头是1
        curRow.add(1);

        // base case
        if (rowIndex == 0) {
            return curRow;
        }

        // 递归计算上一行
        List<Integer> prevRow = getRow(rowIndex - 1);
        for (int i = 0; i < prevRow.size() - 1; i++) {
            // 这一行每个元素等于上一行两个相邻元素之和
            curRow.add(prevRow.get(i) + prevRow.get(i + 1));
        }
        // 每一行的结尾是1
        curRow.add(1);
        return curRow;
    }
}