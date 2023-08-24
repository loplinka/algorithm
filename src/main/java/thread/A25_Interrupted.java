/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package thread;

/**
 *
 * 通过调用一个线程的 interrupt() 来中断该线程，如果该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛出 InterruptedException，从而提前结束该线程。但是不能中断 I/O 阻塞和 synchronized 锁阻塞。
 *
 * @author baojiang
 * @version 中断: A25_Interrupted.java, v 0.1 2022年10月27日 下午9:08 baojiang Exp $
 */
public class A25_Interrupted extends Thread {


    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new A25_Interrupted();
        thread.start();
        thread.interrupt();
        System.out.println("Main run");
    }
}