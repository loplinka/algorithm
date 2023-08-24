/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package ha;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author baojiang
 * @version 单机限流: A5_SingleMachineLimit.java, v 0.1 2022年10月31日 下午2:45 baojiang Exp $
 */
public class A5_SingleMachineLimit {

    public static void main(String[] args) {

        test1();

        test2();

    }

    public static void test1() {
        // 1s 放 5 个令牌到桶里也就是 0.2s 放 1个令牌到桶里
        RateLimiter rateLimiter = RateLimiter.create(5);
        for (int i = 0; i < 5; i++) {
            double sleepingTime = rateLimiter.acquire();
            System.out.printf("get 1 tokens: %ss%n", sleepingTime);
        }

    }


    public static void test2() {
        // 1s 放 5 个令牌到桶里也就是 0.2s 放 1个令牌到桶里
        // 预热时间为3s,也就说刚开始的 3s 内发牌速率会逐渐提升到 0.2s 放 1 个令牌到桶里
        RateLimiter rateLimiter = RateLimiter.create(5, 3, TimeUnit.SECONDS);
        for (int i = 0; i < 20; i++) {
            double sleepingTime = rateLimiter.acquire(1);
            System.out.printf("get 1 tokens: %sds%n", sleepingTime);
        }

    }
}