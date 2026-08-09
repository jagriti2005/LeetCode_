class Solution {
    class Pair{
        String word;
        int val;
        Pair(String word, int val){
            this.word = word;
            this.val = val;
        }
    }
    public int ladderLength(String start, String end, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();

        if(!set.contains(end)) return 0;

        q.add(new Pair(start, 1));
        set.remove(start);

        while(q.size() > 0){
            Pair curr = q.poll();
            String word = curr.word;
            char[] arr = word.toCharArray();

            int val = curr.val;

            if(word.equals(end)) return val;

            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                for(char j='a';j<='z';j++){
                    arr[i] = j;
                    String temp = new String(arr);

                    if(set.contains(temp)) q.add(new Pair(temp, val+1));
                    set.remove(temp);
                }
                arr[i] = ch;
            }
        }
        return 0;
    }
}