class Solution {
    class Pair{
        int row;
        int col;
        int parentrow;
        int parentcol;
        Pair(int row,int col,int parentrow,int parentcol){
            this.row = row;
            this.col = col;
            this.parentrow = parentrow;
            this.parentcol = parentcol;
        }
    }
    int rowDirection[] = {1,-1,0,0};
    int colDirection[] = {0,0,1,-1};

    public boolean bfs(char[][] grid,boolean[][] vis,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j,-1,-1));
        vis[i][j] = true;
        while(q.size()>0){
            Pair curr = q.remove();
            int currrow = curr.row;
            int currcol = curr.col;
            int currParentRow = curr.parentrow;
            int currParentCol = curr.parentcol;
            for(int k=0;k<4;k++){
                int newRow = currrow + rowDirection[k];
                int newCol = currcol + colDirection[k];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol] == grid[currrow][currcol]){
                    if(!vis[newRow][newCol]){
                        q.add(new Pair(newRow,newCol,currrow,currcol));
                        vis[newRow][newCol] = true;
                    } 
                    else if(currParentRow != newRow || currParentCol != newCol) return true;
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    if(bfs(grid,vis,i,j)) return true;
                }
            }
        }
        return false;
    }
}