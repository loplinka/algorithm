package thread; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 *
 * @author baojiang
 * @version ThreadMXBean: thread.A21_ThreadMXBean.java, v 0.1 2022��10��19�� ����9:51 baojiang Exp $
 */
public class A21_ThreadMXBean {
    public static void main(String[] args) throws IOException {

        // ��ȡ Java �̹߳��� MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // ����Ҫ��ȡͬ���� monitor �� synchronizer ��Ϣ������ȡ�̺߳��̶߳�ջ��Ϣ
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // �����߳���Ϣ������ӡ�߳� ID ���߳�������Ϣ
        for (ThreadInfo threadInfo : threadInfos) {

            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName() +" "+ threadInfo.getThreadState());
        }


    }
}