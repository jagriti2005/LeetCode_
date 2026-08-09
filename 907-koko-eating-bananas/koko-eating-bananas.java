class Solution {
    public boolean isPossible(int k, int[] piles, int h){
        long time = 0;
        for(int p:piles) time += (p+k-1)/k;
        return time <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;
        for(int p:piles) hi = Math.max(hi,p);

        int ans = hi;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(isPossible(mid,piles,h)){
                ans = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ans;
    }
}