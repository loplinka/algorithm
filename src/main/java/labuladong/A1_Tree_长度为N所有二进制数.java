/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

/**
 * @author Baojiang Yang
 * @version : A1_Tree_����ΪN���ж�������.java, v 0.1 2023��09��18�� 00:42  Baojiang Yang Exp $
 */
public class A1_Tree_����ΪN���ж������� {

    static StringBuilder path = new StringBuilder();

    /**
     * ���ɳ���ΪN���ж�������
     * 1.��ʵ����������ı��������п��ܵ�·��
     * 2.�����˼����ǰ�һ������ת����N�����ı�������
     * 3.��ס����N�����ݵĻ����������,Ȼ���ǰ��ͺ��������ŵ�forѭ����,�����������ڵ�
     * 4.����ٻ���һ��N�����ݵı������:
     *  step1: �Ӹ��ڵ���Ҷ�ӽڵ����,���ڽ���ǰ���ʱ������¼(��ɫ��ͷ)
     *  step2: ���������Ҷ�ӽڵ������ڵ㷵��ʱ,Ҫά��,���������,Ҫô--Ҫôɾ��(��ɫ��ͷ)
     * 5.����ǻ����㷨�ĺ���˼��
     * @param n
     *
     */
    static void genBinNumber(int n) {
        if (n == 0) {
            System.out.println(path.toString());
            return;
        }

        // �˴�2�Ƕ���ɨ�ʹ�������,������10����10����
        for (int i = 0; i < 2; i++) {
            // ǰ��λ��,����ڵ�
            path.append(i);
            // �ݹ��ӽڵ�, ��ʱ��n���ǲ���,ÿ��һ��ͼ�1
            genBinNumber(n - 1);
            // ����λ��,�뿪�ڵ�
            path.deleteCharAt(path.length() - 1);
        }

    }

    public static void main(String[] args) {
        genBinNumber(3);
    }

}