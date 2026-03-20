import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        
        // For each possible top-left corner
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                ans[i][j] = getMinDifference(grid, i, j, k);
            }
        }
        
        return ans;
    }
    
    private int getMinDifference(int[][] grid, int startRow, int startCol, int k) {
        // Use TreeSet to maintain sorted distinct values
        TreeSet<Integer> distinctValues = new TreeSet<>();
        
        // Collect all distinct values in the k×k submatrix
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                distinctValues.add(grid[startRow + i][startCol + j]);
            }
        }
        
        // If only one distinct value, answer is 0
        if (distinctValues.size() == 1) {
            return 0;
        }
        
        // Find minimum absolute difference between consecutive distinct values
        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;
        
        for (int val : distinctValues) {
            if (prev != null) {
                int diff = val - prev; // Since TreeSet is sorted, val > prev
                minDiff = Math.min(minDiff, diff);
            }
            prev = val;
        }
        
        return minDiff;
    }
}