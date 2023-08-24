/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package ha;

import tools.DateUtil;

import java.time.LocalDateTime;

/**
 *
 * @author baojiang
 * @version 固定窗口限流: A1_FixWindow.java, v 0.1 2022年10月28日 下午2:52 baojiang Exp $
 */
public class A1_FixWindowLimit {

    // 可以配置的时间窗口
    private long          m     = 60000;
    // 第一次请求时间
    private LocalDateTime startTime;
    // 可以配置的请求数
    private int           n     = 10;
    // 计数器
    private int           count = 0;

    /**
     * 埋点在请求入口,不断更新队列
     */
    public void request() {
        // 第一个请求
        if (count == 0) {
            startTime = LocalDateTime.now();
        }
        // 计数已经满了,重置计数器
        if (!allow()) {
            count = 0;
        }
        count++;
    }

    /**
     * 是否允许新的请求
     * @return
     */
    public boolean allow() {
        if (DateUtil.betweenMillis(LocalDateTime.now(), startTime) >= m && count >= n) {
            return false;
        }
        return true;
    }

}

