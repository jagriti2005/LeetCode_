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
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean found = false;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    Queue<Pair> temp = new LinkedList<>();
                    temp.add(new Pair(i,j));
                    grid[i][j] = 2;

                    while(temp.size()>0){
                        Pair front = temp.remove();
                        q.add(front);
                        for(int k=0;k<4;k++){
                            int nr = front.r + rowD[k];
                            int nc = front.c + colD[k];

                            if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc] == 1){
                                temp.add(new Pair(nr,nc));
                                grid[nr][nc] = 2;
                            }
                        }
                    }
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        int steps=0;
        while(q.size()>0){
            int size = q.size();
            while(size-- >0){
                Pair curr = q.remove();
                for(int i=0;i<4;i++){
                    int nr = curr.r + rowD[i];
                    int nc = curr.c + colD[i];

                    if(nr<0 || nr>=n || nc<0 || nc>=n || grid[nr][nc]==2) continue;
                    if(grid[nr][nc] == 1) return steps;
                    grid[nr][nc] = 2;
                    q.add(new Pair(nr,nc));
                }
            }
            steps++;
        }
        return -1;
    }
}