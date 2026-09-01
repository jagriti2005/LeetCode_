import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sx = 0, sy = 0;
        int count = 0;

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    sx = i;
                    sy = j;
                }

                if (c == 'L') {
                    grid[i][j] = count;
                    count++;
                }
            }
        }

        if (count == 0) return 0;

        int full = (1 << count) - 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, energy, full});

        boolean[][][][] vis =
            new boolean[m][n][energy + 1][1 << count];

        vis[sx][sy][energy][full] = true;

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] cur = q.poll();

                int x = cur[0];
                int y = cur[1];
                int e = cur[2];
                int mask = cur[3];

                if (mask == 0) return moves;

                if (e == 0) continue;

                for (int k = 0; k < 4; k++) {

                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx < 0 || nx >= m ||
                        ny < 0 || ny >= n || classroom[nx].charAt(ny) == 'X') {
                        continue;
                    }

                    int ne = e - 1;
                    int nmask = mask;

                    char c = classroom[nx].charAt(ny);


                    if (c == 'R') {
                        ne = energy;
                    }


                    if (c == 'L') {
                        nmask = mask & ~(1 << grid[nx][ny]);
                    }

                    if (!vis[nx][ny][ne][nmask]) {

                        vis[nx][ny][ne][nmask] = true;

                        q.add(new int[]{
                            nx, ny, ne, nmask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}