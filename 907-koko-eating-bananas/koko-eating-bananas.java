class Solution {
    public boolean canFinish(int[] piles, int k, int h){
        long hour = 0;
        for(int p:piles){
            hour += (long)(p+k-1)/k;
        }
        return hour<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int p:piles) right = Math.max(right,p);
        int ans = right;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canFinish(piles,mid,h)){
                ans = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return ans;
    }
}