package io; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.io.*;

/**
 *
 * @author baojiang
 * @version �ַ���: A32_IO_ReadWriter.java, v 0.1 2022��10��27�� ����4:30 baojiang Exp $
 */
public class A32_IO_ReaderWriter {

    public static void main(String[] args) throws FileNotFoundException {

        // �ַ�������
        //fileReaderTest();

        // �ַ������
        fileWriterTest();
    }

    public static void fileReaderTest() throws FileNotFoundException {
        try {
            String path = "/Users/baojiang/MeiTuanProjects/algorithm/src/main/resources/input.txt";

            Reader fileReader = new FileReader(path);
            int content;
            long skip = fileReader.skip(3);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fileReader.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void fileWriterTest() {

        try {

            String path = "/Users/baojiang/MeiTuanProjects/algorithm/src/main/resources/outData.txt";

            A32_IO_InputOutStream.deleteFile(path);

            Writer writer = new FileWriter(path);

            writer.write("���!");
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}