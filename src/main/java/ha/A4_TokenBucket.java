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
 * @version 令牌桶: A4_TokenBubket.java, v 0.1 2022年10月28日 下午3:45 baojiang Exp $
 */
public class A4_TokenBucket {

    // 令牌桶
    private Deque<Token>             bucket     = new ArrayDeque<>();
    // 令牌
    private int                      bucketSize = 10;
    // 添加令牌
    private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);

    // 构造固定速率添加令牌
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
            System.out.println("桶满,添加令牌失败!");
            return;
        }
        bucket.offer(new Token());
    }

    /**
     * 请求处理完后丢弃令牌
     */
    public Token getToken() {
        if (allow()) {
            return bucket.pollLast();
        }
        System.out.println("没有可用令牌,当前被限流!");
        return null;
    }

    /**
     * 是否允许新的请求
     * @return
     */
    public boolean allow() {
        // 拿到令牌
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