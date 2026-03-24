// class Solution {
//     public int[] twoSum(int[] arr, int x) {
//         int[] ans = new int[2];
//         for (int i = 0; i < arr.length; i++) {
//             for(int j=i+1;j< arr.length;j++){
//                 if(arr[i]+arr[j]==x){
//                     ans[0] =i;
//                     ans[1] =j;
//                     break;
                    
//                 }
//             }
//         }
//         return ans;
//     }
// }


class Solution{
    public int[] twoSum(int[] nums, int x){
        int[] ans = {-1,-1};
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int key = nums[i];
            int rem = x-key;
            if(map.containsKey(rem)){
                int j = map.get(rem);
                ans[0] = i;
                ans[1] = j;
                break;
            }
            else{
                map.put(key,i);
            }
        }
        return ans;
    }
}