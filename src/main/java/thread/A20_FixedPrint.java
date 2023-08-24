package thread; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 *
 * @author baojiang
 * @version 交替打印: thread.A20_FixedPrint.java, v 0.1 2022年10月17日 下午3:36 baojiang Exp $
 */
public class A20_FixedPrint {

    /**
     * synchronized 实现
     */
    static class Print1 implements Runnable {

        public       int i = 0;
        public final int n = 100;

        @Override
        public void run() {
            synchronized (this) {
                while (i < n) {
                    System.out.println(i++ + Thread.currentThread().getName());

                    notify();

                    try {
                        Thread.sleep(5);
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        public static void main(String[] args) {

            Print1 p = new Print1();
            Thread t1 = new Thread(p);
            Thread t2 = new Thread(p);

            t1.setName("A====");
            t2.setName("B");

            t1.start();
            t2.start();

        }

    }

    /**
     * 信号量
     */
    static class Solution2 {

        public static void main(String[] args) {
            final AtomicInteger i = new AtomicInteger(0);
            final int n = 21;
            final Semaphore x1 = new Semaphore(1);
            final Semaphore x2 = new Semaphore(0);
            final Semaphore x3 = new Semaphore(0);
            new Thread(() -> {
                while (i.get() < n) {
                    x1.acquireUninterruptibly();
                    if (i.get() < n) {
                        System.out.println(i.getAndIncrement() + ":A==========");
                    }
                    x2.release();
                }
            }).start();

            new Thread(() -> {
                while (i.get() < n) {
                    x2.acquireUninterruptibly();
                    if (i.get() < n) {
                        System.out.println(i.getAndIncrement() + ":B==");
                    }
                    x3.release();
                }
            }).start();

            new Thread(() -> {
                while (i.get() < n) {
                    x3.acquireUninterruptibly();
                    if (i.get() < n) {
                        System.out.println(i.getAndIncrement() + ":C");
                    }
                    x1.release();
                }
            }).start();

        }
    }

    /**
     * LockSupport
     */
    static class Solution3 {
        static Thread t1 = null;
        static Thread t2 = null;

        public static void main(String[] args) {

            final char[] aI = "1234567".toCharArray();
            final char[] aC = "ABCDEFG".toCharArray();

            t1 = new Thread(() -> {
                for (char c : aC) {
                    System.out.println(c);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }, "t1");

            t2 = new Thread(() -> {
                for (char c : aI) {
                    LockSupport.park();
                    System.out.println(c);
                    LockSupport.unpark(t1);
                }
            }, "t2");

            t1.start();
            t2.start();
        }

    }

}