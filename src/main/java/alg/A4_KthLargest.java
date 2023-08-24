package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.PriorityQueue;

/**
 *
 * @author baojiang
 * @version 第K大元素: alg.A4_KthLargest.java, v 0.1 2022年09月28日 上午1:24 baojiang Exp $
 */
public class A4_KthLargest {

    // Java优先队列默认使用小顶堆实现
    final PriorityQueue<Integer> q;
    final int                    k;

    /**
     * 构造函数初始化小顶堆
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
     * 每次add前只需要和堆顶元素比较,offer后小顶堆会默认重新排序构造
     * @param val
     * @return
     */
    public int add(int val) {
        if (q.size() < k) {
            // 插入队列
            q.offer(val);

        }
        // 堆顶元素小于当前值
        else if (q.peek() < val) {
            // 移除堆顶元素并重新入堆
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}