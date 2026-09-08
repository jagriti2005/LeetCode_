class Solution {
    public int countCommas(int n) {
        long base = 1000;
        long ans = 0;
        while(base <= n){
            ans += (long)n-base+1;
            base *= 1000;
        }
        return (int)ans;
    }
}