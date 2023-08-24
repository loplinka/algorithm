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
 * @version ThreadMXBean: thread.A21_ThreadMXBean.java, v 0.1 2022年10月19日 下午9:51 baojiang Exp $
 */
public class A21_ThreadMXBean {
    public static void main(String[] args) throws IOException {

        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {

            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName() +" "+ threadInfo.getThreadState());
        }


    }
}