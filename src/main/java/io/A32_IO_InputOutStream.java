package io; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.WatchService;

/**
 *
 * @author baojiang
 * @version �ֽ���: A32_IO.java, v 0.1 2022��10��27�� ����2:16 baojiang Exp $
 */
public class A32_IO_InputOutStream {

    public static void main(String[] args) throws IOException, InterruptedException {

        // �ֽ�������
        //inputStreamTest();

        //bufferedInputStreamTest();

        // dataInputStreamTest();

        // �ֽ������
        //outputStreamTest();

        //BufferedOutputStreamTest();

        DataOutputStreamTest();



    }



    /**
     * �ֽ�������
     */
    public static void inputStreamTest() {

        try {

            //InputStream fis = A32_IO.class.getClassLoader().getResourceAsStream("input.txt");
            //InputStream fis = new FileInputStream("/Users/baojiang/MeiTuanProjects/algorithm/target/classes/input.txt");
            InputStream fis = new FileInputStream(
                    "/Users/baojiang/MeiTuanProjects/algorithm/src/main/resources/input.txt");
            System.out.println("Number of remaining bytes:" + fis.available());

            int content;
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);

            System.out.print("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * �ֽ�������
     */
    public static void bufferedInputStreamTest() {

        try {

            // �½�һ�� BufferedInputStream ����
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(
                    "/Users/baojiang/MeiTuanProjects/algorithm/src/main/resources/input.txt"));

            int content;
            long skip = bufferedInputStream.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);

            System.out.print("The content read from file:");
            while ((content = bufferedInputStream.read()) != -1) {
                System.out.print((char) content);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * �ֽ�������
     */
    public static void dataInputStreamTest() throws IOException {

        // �½�һ�� FileInputStream ����
        FileInputStream fileInputStream = new FileInputStream(
                "/Users/baojiang/MeiTuanProjects/algorithm/src/main/resources/input.txt");
        //���뽫fileInputStream��Ϊ�����������ʹ��
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        //���Զ�ȡ����������������

        int content;
        long skip = dataInputStream.skip(2);

        // dataInputStream.readChar();
        // dataInputStream.readBoolean();
        // dataInputStream.readInt();
        try {
            System.out.println("The actual number of bytes skipped:" + skip);
            while ((content = dataInputStream.read()) != -1) {
                System.out.print((char) content);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dataInputStream.close();
        }

    }

    public static void outputStreamTest() throws IOException {

        OutputStream outputStream = new FileOutputStream(
                "/Users/baojiang/MeiTuanProjects/algorithm/src/main/resources/output.txt");
        try {

            byte[] array = "Yangbaojiang".getBytes();
            outputStream.write(array);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }
    }

    public static void BufferedOutputStreamTest() throws IOException {

        try {

            String path = "/Users/baojiang/MeiTuanProjects/algorithm/src/main/resources/out.txt";

            deleteFile(path);

            OutputStream outputStream = new FileOutputStream(path);

            BufferedOutputStream bos = new BufferedOutputStream(outputStream);

            byte[] array = "Yangbaojiang".getBytes();
            bos.write(array);
            // ��ˢ�»ᴴ���ļ�������д������
            bos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteFile(String path) throws InterruptedException {
        File file = new File(path);
        if (file.exists()) {
            System.out.println(file.delete() ? "ɾ���ļ��ɹ�." : "ɾ���ļ�ʧ��! " + path);
        } else {
            System.out.println("�ļ�������! " + path);
        }

        //Thread.sleep(1000);
    }


    private static void DataOutputStreamTest() throws InterruptedException, IOException {

        String path = "/Users/baojiang/MeiTuanProjects/algorithm/src/main/resources/outData.txt";

        deleteFile(path);

        // �����
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        // ���������������
        dataOutputStream.writeBoolean(true);
        //dataOutputStream.writeByte(1);

        dataOutputStream.flush();

        WatchService watchService = FileSystems.getDefault().newWatchService();


    }

}