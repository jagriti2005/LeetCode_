class Solution {
    public boolean isPoss(int[] weights, int days, int capacity){
        int count = 1;
        int total = 0;
        for(int w:weights){
            if(total+w > capacity){
                count++;
                total = w;
            }
            else total += w;
        }
        return count <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int start = 1;
        int end = 0;
        int ans = 0;
        for(int w:weights){
            start = Math.max(start,w);
            end += w;
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isPoss(weights,days,mid)){
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return ans;
    }
}