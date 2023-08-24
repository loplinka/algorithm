package io; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author baojiang
 * @version ���������: io.A22_InputOutput.java, v 0.1 2022��10��19�� ����9:52 baojiang Exp $
 */
public class A22_InputOutput {
    public static void main(String[] args) throws IOException {




        URL url = new URL("http://www.baidu.com");

        /* �ֽ��� */
        InputStream is = url.openStream();

        /* �ַ��� */
        InputStreamReader isr = new InputStreamReader(is, "utf-8");

        /* �ṩ���湦�� */
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}