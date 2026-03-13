class Solution {
    public boolean isBloom(int[] arr, int m, int k,int days){
        int flower = 0;
        int bouq = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= days){
                flower++;
                if(flower == k){
                    bouq++;
                    flower = 0;
                }
            }
            else flower = 0;
        }
        return bouq >= m;
    }
    public int minDays(int[] arr, int m, int k) {
        int start = 1;
        int end = 0;
        int ans = -1;
        for(int i=0;i<arr.length;i++) end = Math.max(end,arr[i]);
        while(start <= end){
            int mid = (start+ end)/2;
            if(isBloom(arr,m,k,mid)){
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return ans;
    }
}