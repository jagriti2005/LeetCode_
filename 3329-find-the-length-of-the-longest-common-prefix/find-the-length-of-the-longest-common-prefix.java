class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        HashSet<String> set = new HashSet<>();

        int count = 0;

        for(int num : arr1){

            String s = Integer.toString(num);

            for(int i = 1; i <= s.length(); i++){
                set.add(s.substring(0,i));
            }

        }

        for(int num : arr2){
            String s = Integer.toString(num);

            for(int i = 1; i <= s.length(); i++){

                String prefix = s.substring(0,i);
                if(set.contains(prefix)){
                    count = Math.max(count, i);
                }
            }
        }
        
        return count;
    }
}