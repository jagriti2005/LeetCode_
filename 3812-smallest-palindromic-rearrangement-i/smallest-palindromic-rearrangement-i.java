class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n / 2;

        char[] arr = s.toCharArray();

        // Sort first half
        Arrays.sort(arr, 0, mid);

        // Copy first half to second half in reverse order
        for (int i = 0; i < mid; i++) {
            arr[n - i - 1] = arr[i];
        }

        return new String(arr);
        
    }
}