class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            arr[i] = ((arr[i]%k)+k)%k;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        while(left <= right){
            if(arr[left] == 0){
                left++;
                continue;
            }
            if(arr[left] + arr[right] != k || left==right) return false;
            left++;
            right--;
            
        }
        return true;
    }
}