package thread; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *
 * @author baojiang
 * @version ���߳�: thread.A19_MyThread.java, v 0.1 2022��10��17�� ����1:41 baojiang Exp $
 */
public class A19_MyThread extends Thread{

    public void run() {
        System.out.println("Son if a bitch");
    }

    public static void main(String[] args) {
        A19_MyThread instance = new A19_MyThread();
        Thread thread = new Thread(instance);
        thread.start();
    }

}