class Solution {
    class Pair{
        int r,c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    int[] rowD = {0,0,1,-1};
    int[] colD = {-1,1,0,0};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }
        
        while(q.size() > 0){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            for(int k=0;k<4;k++){
                int nr = rowD[k] + r;
                int nc = colD[k] + c;

                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc] == 1 && !vis[nr][nc]){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc] = true;
                    ans[nr][nc] = ans[r][c] + 1;
                }
            }
        }
        return ans;
    }
}