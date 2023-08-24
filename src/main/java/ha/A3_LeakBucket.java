/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package ha;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author baojiang
 * @version 漏桶: A3_LeakBucket.java, v 0.1 2022年10月28日 下午3:17 baojiang Exp $
 */
public class A3_LeakBucket<T> {
    // 桶
    private Deque<T>                 bucket          = new ArrayDeque<>();
    // 桶容量
    private int                      bucketSizeLimit = 10;
    // 固定速率消费请求
    private ScheduledExecutorService threadPool      = Executors.newScheduledThreadPool(10);


    public A3_LeakBucket() {
        init(0L, 1000L);
    }

    public void init(long initialDelay, long period) {
        threadPool.scheduleAtFixedRate(() -> {
            consult(bucket.pollLast());
        }, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    /**
     * 消费请求
     * @param req
     */
    public void consult(T req) {

    }

    /**
     * 埋点在请求入口,不断更新队列
     */
    public void request(T request) {
        if (allow()) {
            bucket.offer(request);
        } else {
            System.out.println("触发限流,请求被丢弃!");
        }

    }

    /**
     * 是否允许新的请求
     * @return
     */
    public boolean allow() {
        return bucket.size() <= bucketSizeLimit;
    }

}