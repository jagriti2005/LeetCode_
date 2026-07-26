class Solution {
    public boolean isBloom(int[] bloomDay, int m, int k, int days){
        int flower = 0;
        int bq = 0;

        for(int n:bloomDay){
            if(n<=days){
                flower++;
                if(flower==k){
                    bq++;
                    flower = 0;
                }
            }
            else flower = 0;
        }

        return bq >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int ans = -1;
        int left = 1;
        int right = 0;
        for(int n:bloomDay) right = Math.max(right,n);

        while(left<=right){
            int mid = (left+right)/2;
            if(isBloom(bloomDay,m,k,mid)){
                ans = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return ans;
    }
}