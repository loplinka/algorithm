package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import com.google.common.collect.Lists;
import tools.PrintUtil;

import java.util.*;

import static tools.PrintUtil.print;

/**
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * @author baojiang
 * @version 返回滑动窗口最大值: alg.A4_SlidingWindowMaximum.java, v 0.1 2022年10月01日 下午12:13 baojiang Exp $
 */
public class A4_SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        PrintUtil.print(maxSlidingWindow1(nums, k));
        print(maxSlidingWindow2(nums, k));

    }

    /**
     * 大顶堆MaxHeap方法
     * 1.维护这个Heap(size=k) N*log(K)的复杂度
     * 2.每次返回Heap的堆顶Top元素即可 O(1)
     */

    public static int[] maxSlidingWindow1(int[] nums, int k) {

        int n = nums.length;

        // PriorityQueue 默认是小顶堆, 所以重写compare方法改成大顶堆,减法就是升降序
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        // 为了方便判断堆顶元素与滑动窗口的位置关系,可以定义二元数组[num, index],表示 元素num 在数组中的下标为index。
        // 前k个元素先入列
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[] { nums[i], i});
        }

        // 构造返回结果数组,其大小就是n-k+1
        int[] ans = new int[n - k + 1];
        // 结果数组第一个元素等于大顶堆top元素
        ans[0] = pq.peek()[0];
        // 开始编辑k以后的元素
        for (int i = k; i < n; ++i) {
            // 遍历当前元素和index先入列
            pq.offer(new int[] { nums[i], i });
            // 队列中index <=
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            // 取堆顶元素,将其放入返回结果数组中
             ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }

    /**
     * 双端队列Deque方法(单调队列)
     * 1.元素入队列,队列长度为k O(N)
     * 2.维护队列,保证进来的元素没有队列左边的大 O(1)
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247493058&idx=1&sn=e41183a0ae6b22293133fa198e4a7836&chksm=9bd41bcaaca392dce95e38e7d59daf81a60b2790927e4f0c9c05d74de2a880f818dfeec1e7e3&scene=178&cur_album_id=2164991053991411713#rd
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        // 循环k次,队列存放的是index,长度<=k
        for (int i = 0; i < k; ++i) {
            // 队列不为空:第一次循环不移除元素,直接加 到队尾部
            // 第二次循环比较第2个数组元素>=队列尾元素,就移除队尾元素,重新入列(替换)
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 再添加至队尾
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        // 从滑动窗口k+1开始循环
        for (int i = k; i < n; ++i) {
            // 当前值比队列尾元素大或则相等,就移除元素,注意此处是while,也就是会比较队列里的全部元素
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 再添加至队尾
            deque.offerLast(i);
            // 队首元素<=
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;

    }


    class Solution {
        /* 单调队列的实现 */
        class MonotonicQueue {
            LinkedList<Integer> q = new LinkedList<>();

            public void push(int n) {
                // 将小于 n 的元素全部删除
                while (!q.isEmpty() && q.getLast() < n) {
                    q.pollLast();
                }
                // 然后将 n 加入尾部
                q.addLast(n);
            }

            public int max() {
                return q.getFirst();
            }

            public void pop(int n) {
                if (n == q.getFirst()) {
                    q.pollFirst();
                }
            }
        }

        /* 解题函数的实现 */
        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue window = new MonotonicQueue();
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    //先填满窗口的前 k - 1
                    window.push(nums[i]);
                } else {
                    // 窗口向前滑动，加入新数字
                    window.push(nums[i]);
                    // 记录当前窗口的最大值
                    res.add(window.max());
                    // 移出旧数字
                    window.pop(nums[i - k + 1]);
                }
            }
            // 需要转成 int[] 数组再返回
            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }

            return arr;
        }
    }

}

