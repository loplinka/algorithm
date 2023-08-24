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
 * ���룺nums = [1,3,-1,-3,5,3,6,7], k = 3
 * �����[3,3,5,5,6,7]
 * ���ͣ�
 * �������ڵ�λ��                ���ֵ
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
 * @version ���ػ����������ֵ: alg.A4_SlidingWindowMaximum.java, v 0.1 2022��10��01�� ����12:13 baojiang Exp $
 */
public class A4_SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        PrintUtil.print(maxSlidingWindow1(nums, k));
        print(maxSlidingWindow2(nums, k));

    }

    /**
     * �󶥶�MaxHeap����
     * 1.ά�����Heap(size=k) N*log(K)�ĸ��Ӷ�
     * 2.ÿ�η���Heap�ĶѶ�TopԪ�ؼ��� O(1)
     */

    public static int[] maxSlidingWindow1(int[] nums, int k) {

        int n = nums.length;

        // PriorityQueue Ĭ����С����, ������дcompare�����ĳɴ󶥶�,��������������
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        // Ϊ�˷����ж϶Ѷ�Ԫ���뻬�����ڵ�λ�ù�ϵ,���Զ����Ԫ����[num, index],��ʾ Ԫ��num �������е��±�Ϊindex��
        // ǰk��Ԫ��������
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[] { nums[i], i});
        }

        // ���췵�ؽ������,���С����n-k+1
        int[] ans = new int[n - k + 1];
        // ��������һ��Ԫ�ص��ڴ󶥶�topԪ��
        ans[0] = pq.peek()[0];
        // ��ʼ�༭k�Ժ��Ԫ��
        for (int i = k; i < n; ++i) {
            // ������ǰԪ�غ�index������
            pq.offer(new int[] { nums[i], i });
            // ������index <=
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            // ȡ�Ѷ�Ԫ��,������뷵�ؽ��������
             ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }

    /**
     * ˫�˶���Deque����(��������)
     * 1.Ԫ�������,���г���Ϊk O(N)
     * 2.ά������,��֤������Ԫ��û�ж�����ߵĴ� O(1)
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247493058&idx=1&sn=e41183a0ae6b22293133fa198e4a7836&chksm=9bd41bcaaca392dce95e38e7d59daf81a60b2790927e4f0c9c05d74de2a880f818dfeec1e7e3&scene=178&cur_album_id=2164991053991411713#rd
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        // ѭ��k��,���д�ŵ���index,����<=k
        for (int i = 0; i < k; ++i) {
            // ���в�Ϊ��:��һ��ѭ�����Ƴ�Ԫ��,ֱ�Ӽ� ����β��
            // �ڶ���ѭ���Ƚϵ�2������Ԫ��>=����βԪ��,���Ƴ���βԪ��,��������(�滻)
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // ���������β
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        // �ӻ�������k+1��ʼѭ��
        for (int i = k; i < n; ++i) {
            // ��ǰֵ�ȶ���βԪ�ش�������,���Ƴ�Ԫ��,ע��˴���while,Ҳ���ǻ�Ƚ϶������ȫ��Ԫ��
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // ���������β
            deque.offerLast(i);
            // ����Ԫ��<=
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;

    }


    class Solution {
        /* �������е�ʵ�� */
        class MonotonicQueue {
            LinkedList<Integer> q = new LinkedList<>();

            public void push(int n) {
                // ��С�� n ��Ԫ��ȫ��ɾ��
                while (!q.isEmpty() && q.getLast() < n) {
                    q.pollLast();
                }
                // Ȼ�� n ����β��
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

        /* ���⺯����ʵ�� */
        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue window = new MonotonicQueue();
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    //���������ڵ�ǰ k - 1
                    window.push(nums[i]);
                } else {
                    // ������ǰ����������������
                    window.push(nums[i]);
                    // ��¼��ǰ���ڵ����ֵ
                    res.add(window.max());
                    // �Ƴ�������
                    window.pop(nums[i - k + 1]);
                }
            }
            // ��Ҫת�� int[] �����ٷ���
            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }

            return arr;
        }
    }

}

