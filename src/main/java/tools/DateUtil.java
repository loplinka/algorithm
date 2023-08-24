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
 * @version ʱ�乤����: DateUtil.java, v 0.1 2022��10��28�� ����3:07 baojiang Exp $
 */
public class DateUtil {

    /**
     * ����ʱ���,���غ���
     * @param after
     * @param before
     * @return
     */
    public static long betweenMillis(LocalDateTime after, LocalDateTime before) {
        if (after == null || before == null) {
            throw new IllegalArgumentException("����쳣!");
        }
        return Duration.between(after, before).toMillis();
    }
}