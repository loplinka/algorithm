/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package practice;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Baojiang Yang
 * @version : A9_Thread_交替输出.java, v 0.1 2024年02月19日 20:38  Baojiang Yang Exp $
 */
public class A9_Thread_交替输出 {

    /**
     * synchronized抢一把lock的方式
     * **************************************** Demo1 ********************************************/
        private static final Object lock      = new Object();
        private static volatile int count     = 0;
        private static final int    MAX_COUNT = 10;

        public static void main(String[] args) {

            Thread t1 = new Thread(new Printer("线程1", 0));
            Thread t2 = new Thread(new Printer("线程2", 1));
            t1.start();
            t2.start();

        }

        static class Printer implements Runnable {
            private final String threadName;
            private final int    target;

            public Printer(String threadName, int target) {
                this.threadName = threadName;
                this.target = target;
            }

            @Override
            public void run() {
                while (count < MAX_COUNT) {
                    synchronized (lock) {
                        if (count % 2 == target) {
                            System.out.println(threadName + ": " + count);
                            count++;
                            // 唤醒等待在lock对象上的线程
                            lock.notify();
                        } else {
                            try {
                                // 当前线程等待
                                lock.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

    /**
     * ReentrantLock+condition方式
     * **************************************** Demo1 ********************************************/

//    private static final ReentrantLock lock      = new ReentrantLock();
//    private static final Condition     condition = lock.newCondition();
//    private static final int           MAX_COUNT = 10;
//    private static volatile int        count     = 0;
//    private static boolean             oddTurn   = true;
//
//    public static void main(String[] args) {
//        Thread t1 = new Thread(new Printer("线程1", true));
//        Thread t2 = new Thread(new Printer("线程2", false));
//        t1.start();
//        t2.start();
//    }
//
//    static class Printer implements Runnable {
//        private final String  threadName;
//        private final boolean isOdd;
//
//        public Printer(String threadName, boolean isOdd) {
//            this.threadName = threadName;
//            this.isOdd = isOdd;
//        }
//
//        @Override
//        public void run() {
//            while (count > MAX_COUNT) {
//                lock.lock();
//                try {
//                    while (isOdd != oddTurn || (isOdd && count % 2 == 0) || (!isOdd && count % 2 == 1)) {
//                        condition.await();
//                    }
//                    System.out.println(threadName + ": " + count);
//                    count++;
//                    oddTurn = !oddTurn;
//                    condition.signalAll();
//                } catch (Throwable t) {
//                    t.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }
//    }

    /**
     * 使用两个Semaphore1和Semaphore2,两个信号量交替acquire和release,实现交替输出
     * **************************************** Demo1 ********************************************/
//    private static final Semaphore semaphore1 = new Semaphore(1);
//    private static final Semaphore semaphore2 = new Semaphore(0);
//    private static final int       MAX_COUNT  = 10;
//    private static volatile int    count      = 0;
//
//    public static void main(String[] args) {
//        Thread t1 = new Thread(new Printer("Thread-1", semaphore1, semaphore2, 0));
//        Thread t2 = new Thread(new Printer("Thread-2", semaphore2, semaphore1, 1));
//
//        t1.start();
//        t2.start();
//    }
//
//    static class Printer implements Runnable {
//        private final String    threadName;
//        private final Semaphore currentSemaphore;
//        private final Semaphore nextSemaphore;
//        private final int       remainder;
//
//        public Printer(String threadName, Semaphore currentSemaphore, Semaphore nextSemaphore, int remainder) {
//            this.threadName = threadName;
//            this.currentSemaphore = currentSemaphore;
//            this.nextSemaphore = nextSemaphore;
//            this.remainder = remainder;
//        }
//
//        @Override
//        public void run() {
//            try {
//                while (count < MAX_COUNT) {
//                    currentSemaphore.acquire();
//                    if (count % 2 == remainder) {
//                        System.out.println(threadName + ": " + count);
//                        count++;
//                    }
//                    nextSemaphore.release();
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}