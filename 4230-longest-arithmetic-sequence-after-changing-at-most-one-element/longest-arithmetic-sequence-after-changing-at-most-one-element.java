class Solution {
    public int longestArithmetic(int[] arr) {
        int n = arr.length;
        if( n <= 2) return n;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 2);
        Arrays.fill(right, 2);

        for(int i = 2; i < n; i++){
            if(arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]){
                left[i] = left[i - 1] + 1;
            }
        }

        for(int i = n - 3; i >= 0; i--){
            if(arr[i + 1] - arr[i] == arr[i + 2] - arr[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 2;

        for(int i = 1; i < n -1; i++){
            ans = Math.max(ans, left[i- 1] + 1);
            ans = Math.max(ans, right[i + 1] + 1);

            int sum = arr[i + 1] - arr[i - 1];

            if(sum % 2 == 0){
                int d = sum/ 2;
                int l = 1;
                int r = 1;

                if(i >= 2 && arr[i - 1]- arr[i -2] == d){
                    l = left[i - 1];
                }

                if(i <= n-3 && arr[i + 2]- arr[i + 1] == d){
                    r = right[i + 1];
                }

                ans = Math.max(ans, l + r + 1);
            }
        }
        ans = Math.max(ans, right[1] + 1);
        ans = Math.max(ans, left[n -2] + 1);

        return Math.min(ans, n);    
    }
}