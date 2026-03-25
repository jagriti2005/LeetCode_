class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;
        for(int[] arr:grid){
            for(int val:arr){
                total += val;
            }
        }
        if(total%2==1) return false;
        long sum  = 0;
        long half = total/2;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
                sum += grid[i][j];
            }
            if(sum==half) return true;
        }
        sum = 0;
        for(int j=0;j<n-1;j++){
            for(int i=0;i<m;i++){
                sum += grid[i][j];
            }
            if(sum==half) return true;
        }
        return false;
    }
}