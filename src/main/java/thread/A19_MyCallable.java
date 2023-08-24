package thread; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @author baojiang
 * @version ���߳�: thread.A19_MyCallable.java, v 0.1 2022��10��17�� ����1:38 baojiang Exp $
 */
public class A19_MyCallable implements Callable<Integer> {

    @Override
    public Integer call() {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        A19_MyCallable instance = new A19_MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(instance);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}