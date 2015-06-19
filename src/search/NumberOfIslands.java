package search;

public class NumberOfIslands {
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    grid[i][j] = '0';
                    dfsMark(i, j, grid.length, grid[i].length, grid);
                }
            }
        }
        return ans;
    }
    
    void dfsMark(int n, int m, int nn, int mm, char[][] grid) {
        for (int i = 0; i < 4; i++) {
            int x = n + dir[i][0];
            int y = m + dir[i][1];
            if (x < 0 || x >= nn || y < 0 || y >= mm) continue;
            if (grid[x][y] == '1') {
                grid[x][y] = '0';
                dfsMark(x, y, nn, mm, grid);
            }
        }
    }
}
