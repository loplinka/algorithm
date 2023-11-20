package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *
 * @author baojiang
 * @version ������ӡ: alg.A16_PrintLuoXuan.java, v 0.1 2022��10��07�� ����9:24 baojiang Exp $
 */
public class A16_PrintLuoXuan {

    public static void main(String[] args) throws InterruptedException {

        // �Լ�
        printScrew(9);
        // �ٷ�
        SpiralMatrix.printScrew(9);

    }


    /**
     * ��ӡ
     * @param n
     * @throws InterruptedException
     */
    public static void printScrew(int n) throws InterruptedException {

        int[][] data = create(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String s;
                if (i == 0) {
                    s = "0" + data[i][j] + " ";
                } else {
                    s = data[i][j] + " ";
                }
                Thread.currentThread().sleep(100);
                System.out.print(s);
            }
            System.out.println();
        }
    }


    public static int[][]  create(int n) {
        // ��ʼ����Ԫ�ض�����0
        int[][] data = new int[n][n];
        // Ԫ������
        int total = n * n;
        // ����
        int right= 1;
        int down = 2;
        int left = 3;
        int up = 4;
        int direction = right;


        // ��
        int r = 0;
        // ��
        int c = 0;

        // �����ۼ�n*n��Ԫ��,��������ӵ���ά������
        for (int i = 1; i <= total; i ++) {
            data[r][c] = i;
            // ����
            if (direction == right) {
                // ��������û�г����߽�n,����Ԫ��û�б��޸Ĺ�, ���в��䣬�к������ƶ�һλ
                if (c + 1 < n && data[r][c + 1] == 0) {
                    c++;
                }
                // ���в��䣬�к������ƶ�һλ,�����޸ķ���
                else {
                    r++;
                    direction = down;
                    // ����ѭ��
                    continue;
                }
            }

            // ����
            if (direction == down) {
                if (r + 1 < n && data[r + 1][c] == 0) {
                    r++;
                } else {
                    c--;
                    direction = left;
                    // ����ѭ��
                    continue;
                }
            }

            // ����
            if (direction == left) {
                if (c - 1 >= 0 && data[r][c - 1] == 0) {
                    c--;
                } else {
                    r--;
                    direction = up;
                    // ����ѭ��
                    continue;
                }
            }

            // ����
            if (direction == up) {
                if (r - 1 >= 0 && data[r - 1][c] == 0) {
                    r--;
                } else {
                    c++;
                    direction = right;
                    // ����ѭ��
                    continue;
                }
            }
        }

        return data;
    }



    static class SpiralMatrix {

        /**
         * ��ӡ
         * @param n
         * @throws InterruptedException
         */
        public static void printScrew(int n) throws InterruptedException {

            int[][] data = createMatrix(n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    String s;
                    if (i == 0) {
                        s = "0" + data[i][j] + " ";
                    } else {
                        s = data[i][j] + " ";
                    }
                    Thread.currentThread().sleep(100);
                    System.out.print(s);
                }
                System.out.println();
            }
        }

        /**
         * ������������
         * @param n
         * @return
         */
        public static int[][] createMatrix(int n) {

            //n*n�Ķ�ά���飬��ʼԪ��ֵ��Ϊ0
            int[][] matrix = new int[n][n];
            //�ֱ��ʾ���������ĸ�����
            int right = 1, down = 2, left = 3, up = 4;
            int direction = right;
            //n�׾��󣬹���n��n����
            int numb = n * n;

            int i = 0;
            int j = 0;

            // �������1��ʼ����
            for (int p = 1; p <= numb; p++) {
                matrix[i][j] = p;
                //�жϷ������ҵ����
                if (direction == right) {
                    //�����ǰλ�õ�����λ�����ұ߽�����ֵ���ǳ�ʼֵ�����в��䣬�к������ƶ�һλ
                    if (j + 1 < n && matrix[i][j + 1] == 0) {
                        j++;

                    }
                    //��������ұ߽߱磬���������Ԫ���Ѿ����޸Ĺ����������ƶ�һ�У��ҽ������Ϊ����
                    else {
                        i++;
                        direction = down;
                        continue;
                    }
                }

                //�жϷ������µ����
                if (direction == down) {
                    //�����ǰλ�õ�����λ�����±߽�����ֵ���ǳ�ʼֵ�����в��䣬�к������ƶ�һλ
                    if (i + 1 < n && matrix[i + 1][j] == 0) {
                        i++;
                    }
                    //��������±߽磬���������Ԫ���Ѿ����޸Ĺ����������ƶ�һ�У��ҽ������Ϊ����
                    else {
                        j--;
                        direction = left;
                        continue;
                    }
                }

                //�жϷ�����������
                if (direction == left) {
                    //�����ǰλ�õ�����λ������߽�����ֵ���ǳ�ʼֵ�����в��䣬�к������ƶ�һλ
                    if (j - 1 >= 0 && matrix[i][j - 1] == 0) {
                        j--;
                    }
                    //���������߽磬���������Ԫ���Ѿ����޸Ĺ����������ƶ�һ�У��ҽ������Ϊ����
                    else {
                        i--;
                        direction = up;
                        continue;
                    }
                }

                //�жϷ������ϵ����
                if (direction == up) {
                    //�����ǰλ�õ�����λ�����ϱ߽�����ֵ���ǳ�ʼֵ�����в��䣬�к������ƶ�һλ
                    if (i - 1 >= 0 && matrix[i - 1][j] == 0) {
                        i--;
                    }
                    //��������ϱ߽磬���������Ԫ���Ѿ����޸Ĺ����������ƶ�һ�У��ҽ������Ϊ����
                    else {
                        j++;
                        direction = right;
                        continue;
                    }
                }
            }
            return matrix;
        }
    }

}