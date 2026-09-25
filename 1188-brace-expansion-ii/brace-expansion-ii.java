class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = solve(expression);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    public Set<String> solve(String s) {
        Set<String> result = new HashSet<>();
        int level = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                level++;
            } 
            else if (ch == '}') {
                level--;
            } 
            else if (ch == ',' && level == 0) {
                Set<String> left = solve(s.substring(0, i));
                Set<String> right = solve(s.substring(i + 1));
                result.addAll(left);
                result.addAll(right);
                return result;
            }
        }

        // concatenation
        level = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                level++;
            } 
            else if (ch == '}') {
                level--;
            }

            if (level == 0 && i + 1 < s.length()) {

                Set<String> left = solve(s.substring(0, i + 1));
                Set<String> right = solve(s.substring(i + 1));

                if (!left.isEmpty() && !right.isEmpty()) {
                    for (String a : left) {
                        for (String b : right) {
                            result.add(a + b);
                        }
                    }

                    return result;
                }
            }
        }

        // Remove outer braces
        if (s.charAt(0) == '{' && s.charAt(s.length() - 1) == '}') {
            return solve(s.substring(1, s.length() - 1));
        }
        result.add(s);
        return result;
    }
}