class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    int rowDirection[] ={1,-1,0,0};
    int colDirection[] ={0,0,1,-1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                }
            }
        }
        int min = 0;
        while(q.size() > 0){
            int size = q.size();
            boolean flag = false;
            while(size != 0){
                size--;
                Pair front = q.remove();
                int currPairRow = front.row;
                int currPairCol = front.col;
                for(int i=0;i<4;i++){
                    int newRow = currPairRow + rowDirection[i];
                    int newCol = currPairCol + colDirection[i];
                    if(newRow>=0 && newRow<m && newCol>=0 && newCol<n){
                        if(grid[newRow][newCol] == 1 && !vis[newRow][newCol]){
                            flag = true;
                            q.add(new Pair(newRow,newCol));
                            vis[newRow][newCol] = true;
                            grid[newRow][newCol] = 2;
                        } 
                    }
                }
            }
            if(flag == true) min++;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return min;
    }
}