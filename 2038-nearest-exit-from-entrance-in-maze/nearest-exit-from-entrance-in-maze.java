class Solution {
    class Tuple{
        int r,c,d;
        Tuple(int r,int c,int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    int[] rowD = {-1, 1, 0, 0};
    int[] colD = {0, 0, -1, 1};
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(entrance[0],entrance[1],0));
        vis[entrance[0]][entrance[1]] = true;
        while(q.size()>0){
            Tuple curr = q.remove();
            int r = curr.r;
            int c = curr.c;
            int d = curr.d;
            for(int i=0;i<4;i++){
                int nr = r + rowD[i];
                int nc = c + colD[i];
                if(nr>=0 && nr<n &&  nc>=0 && nc<m && maze[nr][nc] == '.' && !vis[nr][nc]){
                    if(nr == 0  || nr ==  n - 1 || nc == m - 1 || nc == 0){
                        return d + 1;   
                    }
                    q.add(new Tuple(nr,nc,d+1));
                    vis[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}