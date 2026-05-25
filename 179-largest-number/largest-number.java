class Solution {
    public String largestNumber(int[] nums) {
        String[] st = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            st[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(st,(a,b) -> (b+a).compareTo(a+b));

        if(st[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(String s:st) sb.append(s);

        return sb.toString();
    }
}