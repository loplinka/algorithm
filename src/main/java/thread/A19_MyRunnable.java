package thread; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *
 * @author baojiang
 * @version ���߳�: thread.A19_MyThread.java, v 0.1 2022��10��17�� ����1:34 baojiang Exp $
 */
public class A19_MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        A19_MyRunnable instance = new A19_MyRunnable();
        Thread thread = new Thread(instance);
        thread.start();
    }
}