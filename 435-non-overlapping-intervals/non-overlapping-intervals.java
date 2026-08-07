class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
        
        int count = 1;
        int prev = intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            int[] curr = intervals[i];
            
            if(curr[0] >= prev){
                count++;
                prev = curr[1];
            }
        }
        
        return intervals.length-count;
    }
}