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
 * @version ©Ͱ: A3_LeakBucket.java, v 0.1 2022��10��28�� ����3:17 baojiang Exp $
 */
public class A3_LeakBucket<T> {
    // Ͱ
    private Deque<T>                 bucket          = new ArrayDeque<>();
    // Ͱ����
    private int                      bucketSizeLimit = 10;
    // �̶�������������
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
     * ��������
     * @param req
     */
    public void consult(T req) {

    }

    /**
     * ������������,���ϸ��¶���
     */
    public void request(T request) {
        if (allow()) {
            bucket.offer(request);
        } else {
            System.out.println("��������,���󱻶���!");
        }

    }

    /**
     * �Ƿ������µ�����
     * @return
     */
    public boolean allow() {
        return bucket.size() <= bucketSizeLimit;
    }

}