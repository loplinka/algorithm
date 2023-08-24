package thread; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *
 * @author baojiang
 * @version 线程本地存储: thread.A21_ThreadLocal.java, v 0.1 2022年10月17日 下午4:30 baojiang Exp $
 */
public class A21_ThreadLocal {

    public static void main(String[] args) {
        final ThreadLocal threadLocal = new ThreadLocal();
        final Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            threadLocal.remove();
        });

        thread1.start();
        thread2.start();

    }
}