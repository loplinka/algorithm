package thread; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *
 * @author baojiang
 * @version 多线程: thread.A19_MyThread.java, v 0.1 2022年10月17日 下午1:41 baojiang Exp $
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