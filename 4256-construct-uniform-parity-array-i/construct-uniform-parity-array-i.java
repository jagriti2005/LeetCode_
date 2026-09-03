class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd = 0,even =0;
        for(int num:nums1){
            if(num%2==1) odd++;
            else even++;
        }
        if(even > 0) return true;
        if(odd > 0) return true;
        return false;
    }
}