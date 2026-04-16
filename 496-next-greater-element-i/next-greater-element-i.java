import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }
            if (st.isEmpty()) {
                map.put(num, -1);
            } else {
                map.put(num, st.peek());
            }
            st.push(num);
        }
        int m = nums1.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}