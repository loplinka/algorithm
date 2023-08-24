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
 * @version ��������: A5_SingleMachineLimit.java, v 0.1 2022��10��31�� ����2:45 baojiang Exp $
 */
public class A5_SingleMachineLimit {

    public static void main(String[] args) {

        test1();

        test2();

    }

    public static void test1() {
        // 1s �� 5 �����Ƶ�Ͱ��Ҳ���� 0.2s �� 1�����Ƶ�Ͱ��
        RateLimiter rateLimiter = RateLimiter.create(5);
        for (int i = 0; i < 5; i++) {
            double sleepingTime = rateLimiter.acquire();
            System.out.printf("get 1 tokens: %ss%n", sleepingTime);
        }

    }


    public static void test2() {
        // 1s �� 5 �����Ƶ�Ͱ��Ҳ���� 0.2s �� 1�����Ƶ�Ͱ��
        // Ԥ��ʱ��Ϊ3s,Ҳ��˵�տ�ʼ�� 3s �ڷ������ʻ��������� 0.2s �� 1 �����Ƶ�Ͱ��
        RateLimiter rateLimiter = RateLimiter.create(5, 3, TimeUnit.SECONDS);
        for (int i = 0; i < 20; i++) {
            double sleepingTime = rateLimiter.acquire(1);
            System.out.printf("get 1 tokens: %sds%n", sleepingTime);
        }

    }
}