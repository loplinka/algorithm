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
 * @version ������������: ha.MyLimit.java, v 0.1 2022��10��28�� ����11:59 baojiang Exp $
 */
public class A2_SlidingWindowLimit {

    // �������õ�ʱ�䴰��
    private long                 m     = 1000;
    // �������õ�������
    private int                  n     = 10;
    // ˫�˶���
    private Deque<LocalDateTime> queue = new ArrayDeque<>();

    public A2_SlidingWindowLimit(long m, int n) {
        this.m = m;
        this.n = n;
    }

    /**
     * ������������,���ϸ��¶���
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
     * �Ƿ������µ�����
     * @return
     */
    public boolean allow() {
        if (DateUtil.betweenMillis(queue.peekFirst(), queue.peekLast()) >= m && queue.size() >= n) {
            return false;
        }
        return true;
    }

}