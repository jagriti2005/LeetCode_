class Solution {
    class Pair{
        int r,c;
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }

    int[] rowD = {0,0,1,-1};
    int[] colD = {-1,1,0,0};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2 && !vis[i][j]){
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                }
            }
        }

        int min = 0;

        while(q.size() > 0){
            int size = q.size();
            boolean flag = false;
            while(size-- > 0){
                Pair curr = q.poll();
                int r = curr.r;
                int c = curr.c;
                for(int i=0;i<4;i++){
                    int nr = rowD[i] + r;
                    int nc = colD[i] + c;
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && !vis[nr][nc]){
                        flag = true;
                        q.add(new Pair(nr,nc));
                        vis[nr][nc] = true;
                        grid[nr][nc] = 2;
                    }
                }
            }
            if(flag==true) min++;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return min;
    }
}