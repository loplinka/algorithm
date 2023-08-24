/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package thread;

/**
 *
 * ͨ������һ���̵߳� interrupt() ���жϸ��̣߳�������̴߳������������ڵȴ����������ڵȴ�״̬����ô�ͻ��׳� InterruptedException���Ӷ���ǰ�������̡߳����ǲ����ж� I/O ������ synchronized ��������
 *
 * @author baojiang
 * @version �ж�: A25_Interrupted.java, v 0.1 2022��10��27�� ����9:08 baojiang Exp $
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