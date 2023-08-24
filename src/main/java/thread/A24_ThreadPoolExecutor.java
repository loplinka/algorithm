package thread; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author baojiang
 * @version 线程池: thread.A24_ThreadPoolExecutor.java, v 0.1 2022年10月19日 下午10:52 baojiang Exp $
 */
public class A24_ThreadPoolExecutor implements Runnable {

    private String command;

    public A24_ThreadPoolExecutor(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName() + " Start. Time = " + LocalDateTime.now());
        processCommand();
        System.out
                .println(Thread.currentThread().getName() + " End. Time = " + LocalDateTime.now());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }

    static class ThreadPoolExecutorDemo {
        private static final int  CORE_POOL_SIZE  = 5;
        private static final int  MAX_POOL_SIZE   = 10;
        private static final int  QUEUE_CAPACITY  = 100;
        private static final Long KEEP_ALIVE_TIME = 1L;

        public static void main(String[] args) {

            //使用阿里巴巴推荐的创建线程池的方式
            //通过ThreadPoolExecutor构造函数自定义参数创建
            ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
                    KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                    new ThreadPoolExecutor.CallerRunsPolicy());

            for (int i = 0; i < 10; i++) {
                //创建 MyRunnable 对象（MyRunnable 类实现了Runnable 接口）
                Runnable worker = new A24_ThreadPoolExecutor("" + i);
                //执行Runnable
                executor.execute(worker);
            }
            //终止线程池
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println("Finished all threads");

        }

    }
}