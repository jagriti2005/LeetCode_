class Solution {
    class Tuple{
        int row;
        int col;
        int dist;
        Tuple(int row,int col,int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        boolean[][] vis = new boolean[n][n];
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,1));
        vis[0][0] = true;

        int[] rowDirection = {-1,1,0,0,-1,-1,1,1};
        int[] colDirection = {0,0,-1,1,-1,1,-1,1};

        while(q.size()>0){
            Tuple front = q.remove();
            int currRow = front.row;
            int currCol = front.col;
            int currDist = front.dist;
            if(currRow == n-1 && currCol == n-1) return currDist;
            for(int k =0;k<8;k++){
                int newRow = currRow + rowDirection[k];
                int newCol = currCol + colDirection[k];
                int newDist = currDist + 1;
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol] == 0 && !vis[newRow][newCol]){
                    q.add(new Tuple(newRow,newCol,newDist));
                    vis[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }
}