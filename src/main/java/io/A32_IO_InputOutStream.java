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
 * @version 字节流: A32_IO.java, v 0.1 2022年10月27日 下午2:16 baojiang Exp $
 */
public class A32_IO_InputOutStream {

    public static void main(String[] args) throws IOException, InterruptedException {

        // 字节输入流
        //inputStreamTest();

        //bufferedInputStreamTest();

        // dataInputStreamTest();

        // 字节输出流
        //outputStreamTest();

        //BufferedOutputStreamTest();

        DataOutputStreamTest();



    }



    /**
     * 字节输入流
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
     * 字节输入流
     */
    public static void bufferedInputStreamTest() {

        try {

            // 新建一个 BufferedInputStream 对象
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
     * 字节输入流
     */
    public static void dataInputStreamTest() throws IOException {

        // 新建一个 FileInputStream 对象
        FileInputStream fileInputStream = new FileInputStream(
                "/Users/baojiang/MeiTuanProjects/algorithm/src/main/resources/input.txt");
        //必须将fileInputStream作为构造参数才能使用
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        //可以读取任意具体的类型数据

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
            // 不刷新会创建文件但不必写入内容
            bos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteFile(String path) throws InterruptedException {
        File file = new File(path);
        if (file.exists()) {
            System.out.println(file.delete() ? "删除文件成功." : "删除文件失败! " + path);
        } else {
            System.out.println("文件不存在! " + path);
        }

        //Thread.sleep(1000);
    }


    private static void DataOutputStreamTest() throws InterruptedException, IOException {

        String path = "/Users/baojiang/MeiTuanProjects/algorithm/src/main/resources/outData.txt";

        deleteFile(path);

        // 输出流
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        // 输出任意数据类型
        dataOutputStream.writeBoolean(true);
        //dataOutputStream.writeByte(1);

        dataOutputStream.flush();

        WatchService watchService = FileSystems.getDefault().newWatchService();


    }

}