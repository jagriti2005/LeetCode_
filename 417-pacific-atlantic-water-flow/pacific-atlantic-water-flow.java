class Solution {
    class Pair{
        int r,c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    int m, n;
    int[] rowD = {0,0,-1,1};
    int[] colD = {-1,1,0,0};


    public boolean bfs(int i, int j, int[][] grid){
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        q.add(new Pair(i,j));
        vis[i][j] = true;

        boolean pacific = false, atlantic = false;

        while(q.size() > 0){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            if(r==0 || c==0) pacific = true;
            if(r==m-1 || c==n-1) atlantic = true;
            if(pacific==true && atlantic==true) return true;

            for(int k=0;k<4;k++){
                int nr = rowD[k] + r;
                int nc = colD[k] + c;

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] <= grid[r][c] && !vis[nr][nc]){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc] = true;
                }
            }
        }

        return false;
    }
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        List<List<Integer>> ans = new ArrayList<>();
        m = grid.length;
        n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Integer> list = new ArrayList<>();
                if(bfs(i,j,grid)){
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;
    }
}