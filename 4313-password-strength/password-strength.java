class Solution {
    public int passwordStrength(String password) {
        int points = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<password.length();i++){
            char ch = password.charAt(i);
            if(set.contains(ch)) continue;
            set.add(ch);

            
            if(ch >= 'a' && ch <= 'z') points += 1;
            else if(ch >= 'A' && ch <= 'Z') points += 2;
            else if(ch >= '0' && ch <= '9') points += 3;
            else if(ch=='!' || ch=='@' || ch=='#' || ch=='$') points += 5;
        }

        return points;
    }
}