package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.PriorityQueue;

/**
 *
 * @author baojiang
 * @version ��K��Ԫ��: alg.A4_KthLargest.java, v 0.1 2022��09��28�� ����1:24 baojiang Exp $
 */
public class A4_KthLargest {

    // Java���ȶ���Ĭ��ʹ��С����ʵ��
    final PriorityQueue<Integer> q;
    final int                    k;

    /**
     * ���캯����ʼ��С����
     * @param k
     * @param nums
     */
    public A4_KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int i : nums) {
            add(i);
        }
    }

    /**
     * ÿ��addǰֻ��Ҫ�ͶѶ�Ԫ�رȽ�,offer��С���ѻ�Ĭ������������
     * @param val
     * @return
     */
    public int add(int val) {
        if (q.size() < k) {
            // �������
            q.offer(val);

        }
        // �Ѷ�Ԫ��С�ڵ�ǰֵ
        else if (q.peek() < val) {
            // �Ƴ��Ѷ�Ԫ�ز��������
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}