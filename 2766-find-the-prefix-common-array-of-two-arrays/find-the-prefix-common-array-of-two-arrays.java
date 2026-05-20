class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        for(int curr = 0;curr<n;curr++){
            int count = 0;

            for(int i=0;i<=curr;i++){
                for(int j=0;j<=curr;j++){
                    if(A[i] == B[j]) count++;
                }
            }

            ans[curr] = count;
        }

        return ans;
    }
}