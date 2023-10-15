/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import com.google.common.collect.Lists;

import java.util.Queue;

/**
 * @author Baojiang Yang
 * leecode 200题
 * @version : A2_Tree_岛屿数量.java, v 0.1 2023年10月15日 22:56  Baojiang Yang Exp $
 */
public class A2_Tree_岛屿数量 {

    public int numIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }

        }
        return count;
    }

    /**
     * 使用bfs方法遍历来把个grid[i][j]相连的岛屿淹没掉
     * @param grid
     * @param i
     * @param j
     */
    private void bfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = Lists.newLinkedList();

        q.offer(new int[] { i, j });
        grid[i][j] = '0';

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int k = 0; k < sz; k++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                if (x + 1 < m && grid[x + 1][y] == '1') {
                    q.offer(new int[] { x + 1, y });
                    grid[x + 1][y] = '0';
                }
                if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                    q.offer(new int[] { x - 1, y });
                    grid[x - 1][y] = '0';
                }
                if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                    q.offer(new int[] { x, y - 1 });
                    grid[x][y - 1] = '0';
                }
                if (y + 1 < n && grid[x][y + 1] == '1') {
                    q.offer(new int[] { x, y + 1 });
                    grid[x][y + 1] = '0';
                }
            }
        }
    }

    /**
     * 同理可使用dfs递归的方式来做
     * @param grid
     * @param i
     * @param j
     */
    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}