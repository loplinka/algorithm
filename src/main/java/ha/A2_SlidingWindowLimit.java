package ha; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import tools.DateUtil;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author baojiang
 * @version 滑动窗口限流: ha.MyLimit.java, v 0.1 2022年10月28日 上午11:59 baojiang Exp $
 */
public class A2_SlidingWindowLimit {

    // 可以配置的时间窗口
    private long                 m     = 1000;
    // 可以配置的请求数
    private int                  n     = 10;
    // 双端队列
    private Deque<LocalDateTime> queue = new ArrayDeque<>();

    public A2_SlidingWindowLimit(long m, int n) {
        this.m = m;
        this.n = n;
    }

    /**
     * 埋点在请求入口,不断更新队列
     */
    public void request() {
        int diff = queue.size() - n;
        if (diff > 0) {
            for (int i = 0; i <= diff; i++) {
                queue.removeLast();
            }
        }

        queue.offer(LocalDateTime.now());
    }

    /**
     * 是否允许新的请求
     * @return
     */
    public boolean allow() {
        if (DateUtil.betweenMillis(queue.peekFirst(), queue.peekLast()) >= m && queue.size() >= n) {
            return false;
        }
        return true;
    }

}