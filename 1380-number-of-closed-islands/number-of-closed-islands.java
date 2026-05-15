class Solution {
    class Pair{
        int r,c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    int[] rowD = {0,0,-1,1};
    int[] colD = {-1,1,0,0};

    public boolean bfs(int i, int j, int[][] grid, boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j] = true;

        boolean closed = true;

        while(q.size() > 0){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            if(r==0 || r==n-1 || c==0 || c==m-1) closed = false;
            for(int k=0;k<4;k++){
                int nr = rowD[k] + r;
                int nc = colD[k] + c;
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == 0 && !vis[nr][nc]){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc] = true;
                }
            }
        }
        return closed;
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0 && !vis[i][j]){
                    if(bfs(i,j,grid,vis)) count++;
                }
            }
        }
        return count;
    }
}