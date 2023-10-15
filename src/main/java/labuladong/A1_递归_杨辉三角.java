/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Baojiang Yang
 * @version : A1_�ݹ�_�������.java, v 0.1 2023��09��19�� 01:01  Baojiang Yang Exp $
 */
public class A1_�ݹ�_������� {

    /**
     * ��һ���������,���Ҹ�һ��rowIndex,�����һ�е�����Ԫ��
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curRow = new ArrayList<>();
        // ÿһ�еĿ�ͷ��1
        curRow.add(1);

        // base case
        if (rowIndex == 0) {
            return curRow;
        }

        // �ݹ������һ��
        List<Integer> prevRow = getRow(rowIndex - 1);
        for (int i = 0; i < prevRow.size() - 1; i++) {
            // ��һ��ÿ��Ԫ�ص�����һ����������Ԫ��֮��
            curRow.add(prevRow.get(i) + prevRow.get(i + 1));
        }
        // ÿһ�еĽ�β��1
        curRow.add(1);
        return curRow;
    }
}