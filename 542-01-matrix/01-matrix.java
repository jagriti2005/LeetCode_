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

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }

        while(q.size()>0){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            for(int i=0;i<4;i++){
                int nr = rowD[i] + r;
                int nc = colD[i] + c;

                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && mat[nr][nc] == 1){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr,nc));
                    ans[nr][nc] = ans[r][c] + 1;
                }
            }
        }
        return ans;
    }
}