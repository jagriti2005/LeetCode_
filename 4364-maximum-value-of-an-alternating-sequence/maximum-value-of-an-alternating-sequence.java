class Solution {
    public long maximumValue(int n, int s, int m) {
        if( n == 1) return s;
        long peak = n / 2;
        return (long)s + peak * m  - (peak - 1);
    }
}