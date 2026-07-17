class Solution {
    class Pair{
        int r,c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    int[] rowD = {0,0,-1,1};
    int[] colD = {1,-1,0,0};
    public void bfs(int i, int j, char[][] grid, int m ,int n, boolean[][] vis){
        vis[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(q.size() > 0){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            for(int k=0;k<4;k++){
                int nr = rowD[k] + r;
                int nc = colD[k] + c;

                if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc] && grid[nr][nc] == '1'){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        int count = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    bfs(i,j,grid,m,n,vis);
                    count++;
                }
            }
        }
        return count;
    }
}