class Solution {
    int m, n;
    boolean[][] vis;

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        return dfs(0, 0, grid);
    }

    public boolean dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n || vis[i][j]) return false;

        if (i == m - 1 && j == n - 1) return true;

        vis[i][j] = true;
        int type = grid[i][j];

        // LEFT
        if (type == 1 || type == 3 || type == 5) {
            if (isValid(i, j, i, j - 1, grid) && dfs(i, j - 1, grid)) return true;
        }

        // RIGHT
        if (type == 1 || type == 4 || type == 6) {
            if (isValid(i, j, i, j + 1, grid) && dfs(i, j + 1, grid)) return true;
        }

        // UP
        if (type == 2 || type == 5 || type == 6) {
            if (isValid(i, j, i - 1, j, grid) && dfs(i - 1, j, grid)) return true;
        }

        // DOWN
        if (type == 2 || type == 3 || type == 4) {
            if (isValid(i, j, i + 1, j, grid) && dfs(i + 1, j, grid)) return true;
        }

        return false;
    }

    public boolean isValid(int i, int j, int ni, int nj, int[][] grid) {
        if (ni < 0 || nj < 0 || ni >= m || nj >= n) return false;

        int next = grid[ni][nj];

        if (ni == i && nj == j - 1) { // LEFT
            return next == 1 || next == 4 || next == 6;
        }
        if (ni == i && nj == j + 1) { // RIGHT
            return next == 1 || next == 3 || next == 5;
        }
        if (ni == i - 1 && nj == j) { // UP
            return next == 2 || next == 3 || next == 4;
        }
        if (ni == i + 1 && nj == j) { // DOWN
            return next == 2 || next == 5 || next == 6;
        }

        return false;
    }
}