package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**
 *
 * @author baojiang
 * @version 螺旋打印: alg.A16_PrintLuoXuan.java, v 0.1 2022年10月07日 下午9:24 baojiang Exp $
 */
public class A16_PrintLuoXuan {

    public static void main(String[] args) throws InterruptedException {

        // 自己
        printScrew(9);
        // 官方
        SpiralMatrix.printScrew(9);

    }


    /**
     * 打印
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
        // 初始数组元素都等于0
        int[][] data = new int[n][n];
        // 元素总数
        int total = n * n;
        // 方向
        int right= 1;
        int down = 2;
        int left = 3;
        int up = 4;
        int direction = right;


        // 行
        int r = 0;
        // 列
        int c = 0;

        // 迭代累加n*n个元素,他他们添加到二维数组里
        for (int i = 1; i <= total; i ++) {
            data[r][c] = i;
            // 向右
            if (direction == right) {
                // 数组向右没有超过边界n,并且元素没有被修改过, 则行不变，列号向右移动一位
                if (c + 1 < n && data[r][c + 1] == 0) {
                    c++;
                }
                // 则列不变，行号向下移动一位,并且修改反向
                else {
                    r++;
                    direction = down;
                    // 继续循环
                    continue;
                }
            }

            // 向下
            if (direction == down) {
                if (r + 1 < n && data[r + 1][c] == 0) {
                    r++;
                } else {
                    c--;
                    direction = left;
                    // 继续循环
                    continue;
                }
            }

            // 向左
            if (direction == left) {
                if (c - 1 >= 0 && data[r][c - 1] == 0) {
                    c--;
                } else {
                    r--;
                    direction = up;
                    // 继续循环
                    continue;
                }
            }

            // 向上
            if (direction == up) {
                if (r - 1 >= 0 && data[r - 1][c] == 0) {
                    r--;
                } else {
                    c++;
                    direction = right;
                    // 继续循环
                    continue;
                }
            }
        }

        return data;
    }



    static class SpiralMatrix {

        /**
         * 打印
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
         * 构建螺旋矩阵
         * @param n
         * @return
         */
        public static int[][] createMatrix(int n) {

            //n*n的二维数组，初始元素值都为0
            int[][] matrix = new int[n][n];
            //分别表示右下左上四个方向
            int right = 1, down = 2, left = 3, up = 4;
            int direction = right;
            //n阶矩阵，共有n×n个数
            int numb = n * n;

            int i = 0;
            int j = 0;

            // 输出数从1开始递增
            for (int p = 1; p <= numb; p++) {
                matrix[i][j] = p;
                //判断方向向右的情况
                if (direction == right) {
                    //如果当前位置的右面位置在右边界内且值还是初始值，则行不变，列号向右移动一位
                    if (j + 1 < n && matrix[i][j + 1] == 0) {
                        j++;

                    }
                    //如果超出右边边界，或者右面的元素已经被修改过，则向下移动一行，且将方向改为向下
                    else {
                        i++;
                        direction = down;
                        continue;
                    }
                }

                //判断方向向下的情况
                if (direction == down) {
                    //如果当前位置的下面位置在下边界内且值还是初始值，则列不变，行号向下移动一位
                    if (i + 1 < n && matrix[i + 1][j] == 0) {
                        i++;
                    }
                    //如果超出下边界，或者下面的元素已经被修改过，则向左移动一行，且将方向改为向左
                    else {
                        j--;
                        direction = left;
                        continue;
                    }
                }

                //判断方向向左的情况
                if (direction == left) {
                    //如果当前位置的左面位置在左边界内且值还是初始值，则行不变，列号向左移动一位
                    if (j - 1 >= 0 && matrix[i][j - 1] == 0) {
                        j--;
                    }
                    //如果超出左边界，或者左面的元素已经被修改过，则向上移动一行，且将方向改为向上
                    else {
                        i--;
                        direction = up;
                        continue;
                    }
                }

                //判断方向向上的情况
                if (direction == up) {
                    //如果当前位置的上面位置在上边界内且值还是初始值，则列不变，行号向左移动一位
                    if (i - 1 >= 0 && matrix[i - 1][j] == 0) {
                        i--;
                    }
                    //如果超出上边界，或者上面的元素已经被修改过，则向右移动一列，且将方向改为向右
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