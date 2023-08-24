/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author baojiang
 * @version 锁: A19_LockExample2.java, v 0.1 2022年10月27日 下午9:25 baojiang Exp $
 */
public class A19_LockExample2 {

    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }


    public static void main(String[] args) {
        A19_LockExample2 lockExample1 = new A19_LockExample2();
        A19_LockExample2 lockExample2 = new A19_LockExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->lockExample1.func1());
        executorService.execute(()->lockExample2.func1());

    }
}