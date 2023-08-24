/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package ha;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author baojiang
 * @version ����Ͱ: A4_TokenBubket.java, v 0.1 2022��10��28�� ����3:45 baojiang Exp $
 */
public class A4_TokenBucket {

    // ����Ͱ
    private Deque<Token>             bucket     = new ArrayDeque<>();
    // ����
    private int                      bucketSize = 10;
    // �������
    private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);

    // ����̶������������
    public A4_TokenBucket() {
        threadPool.scheduleAtFixedRate(() -> {
            addToken();
        }, 0L, 3L, TimeUnit.MILLISECONDS);
    }

    public void init(long initialDelay, long period) {
        threadPool.scheduleAtFixedRate(() -> {
            addToken();
        }, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    private void addToken() {
        if (bucket.size() >= bucketSize) {
            System.out.println("Ͱ��,�������ʧ��!");
            return;
        }
        bucket.offer(new Token());
    }

    /**
     * ���������������
     */
    public Token getToken() {
        if (allow()) {
            return bucket.pollLast();
        }
        System.out.println("û�п�������,��ǰ������!");
        return null;
    }

    /**
     * �Ƿ������µ�����
     * @return
     */
    public boolean allow() {
        // �õ�����
        Token token = bucket.peekLast();
        return token != null;
    }


    class Token {
        private  String tokenId = UUID.randomUUID().toString();

        /**
         * Getter method for property <tt>tokenId</tt>.
         *
         * @return property value of tokenId
         */
        public String getTokenId() {
            return tokenId;
        }
    }
}