package thread; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author baojiang
 * @version 锁: LockExample.java, v 0.1 2022年10月17日 下午3:18 baojiang Exp $
 */
public class A19_LockExample implements Runnable{


    private Lock lock = new ReentrantLock();


    @Override
    public void run() {
        funcLock();
    }

    public void funcLock() {
        lock.lock();
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        A19_LockExample lockExample = new A19_LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(lockExample);
        executorService.execute(lockExample);

    }


}