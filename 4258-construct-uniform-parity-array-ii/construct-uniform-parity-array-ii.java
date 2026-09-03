class Solution {
    public boolean uniformArray(int[] nums1) {
       int n = nums1.length;
        int minVal = Integer.MAX_VALUE;
        int odd = 0;
        for(int x:nums1){
            minVal = Math.min(minVal,x);
            if(x%2 != 0) odd++;
        }

        if(odd == 0 || odd == n) return true;
        if(minVal % 2 != 0) return true;
        return false;
    }
}