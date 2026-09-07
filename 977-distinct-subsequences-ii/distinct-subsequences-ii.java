class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] endsWith = new long[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long allPrev = 0;
            for (int i = 0; i < 26; i++) {
                allPrev = (allPrev + endsWith[i]) % MOD;
            }

            endsWith[idx] = (1 + allPrev) % MOD;
        }

        long total = 0;
        for (int i = 0; i < 26; i++) {
            total = (total + endsWith[i]) % MOD;
        }

        return (int) total;
    }
}