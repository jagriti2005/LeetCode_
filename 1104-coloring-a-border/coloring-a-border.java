class Solution {
    class Pair{
        int r,c;
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }

    int[] rowD = {0,0,-1,1};
    int[] colD = {-1,1,0,0};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        List<Pair> borders = new ArrayList<>();

        int original = grid[row][col];

        q.add(new Pair(row,col));
        vis[row][col] = true;

        while(q.size() > 0){

            Pair curr = q.remove();
            int r = curr.r;
            int c = curr.c;

            boolean isBorder = false;

            for(int i=0;i<4;i++){

                int nr = r + rowD[i];
                int nc = c + colD[i];

                if(nr<0 || nr>=n || nc<0 || nc>=m)
                    isBorder = true;

                else if(grid[nr][nc] != original)
                    isBorder = true;

                else if(!vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr,nc));
                }
            }

            if(isBorder)
                borders.add(curr);
        }

        for(Pair p : borders)
            grid[p.r][p.c] = color;

        return grid;
    }
}