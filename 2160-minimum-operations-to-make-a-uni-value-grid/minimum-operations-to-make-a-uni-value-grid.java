class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        int[] arr = new int[n * m];
        int result = 0;
        int k = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[k++] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        int number = arr[arr.length/2];

        for(int num : arr){
            if(num % x != number % x) return -1; 
            result += Math.abs(number - num) /x;  
        }
        return result;      
    } 
}