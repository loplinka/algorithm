/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package tools;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author baojiang
 * @version 时间工具类: DateUtil.java, v 0.1 2022年10月28日 下午3:07 baojiang Exp $
 */
public class DateUtil {

    /**
     * 计算时间差,返回毫秒
     * @param after
     * @param before
     * @return
     */
    public static long betweenMillis(LocalDateTime after, LocalDateTime before) {
        if (after == null || before == null) {
            throw new IllegalArgumentException("入参异常!");
        }
        return Duration.between(after, before).toMillis();
    }
}