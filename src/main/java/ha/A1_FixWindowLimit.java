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
 * @version �̶���������: A1_FixWindow.java, v 0.1 2022��10��28�� ����2:52 baojiang Exp $
 */
public class A1_FixWindowLimit {

    // �������õ�ʱ�䴰��
    private long          m     = 60000;
    // ��һ������ʱ��
    private LocalDateTime startTime;
    // �������õ�������
    private int           n     = 10;
    // ������
    private int           count = 0;

    /**
     * ������������,���ϸ��¶���
     */
    public void request() {
        // ��һ������
        if (count == 0) {
            startTime = LocalDateTime.now();
        }
        // �����Ѿ�����,���ü�����
        if (!allow()) {
            count = 0;
        }
        count++;
    }

    /**
     * �Ƿ������µ�����
     * @return
     */
    public boolean allow() {
        if (DateUtil.betweenMillis(LocalDateTime.now(), startTime) >= m && count >= n) {
            return false;
        }
        return true;
    }

}

