class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            int lo = 0;
            int hi = ans.size() - 1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if (ans.get(mid) < num) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            if (lo == ans.size()) {
                ans.add(num);
            } else {
                ans.set(lo, num);
            }
        }

        return ans.size();
    }
}