class Solution {
    class Pair{
        String word;
        int val;
        Pair(String word,int val){
            this.word = word;
            this.val = val;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(q.size()>0){
            Pair front = q.remove();
            String newWord = front.word;
            char[] wordArr = newWord.toCharArray();
            int newVal = front.val;
            if(newWord.equals(endWord)) return newVal;
            for(int i=0;i<newWord.length();i++){
                char original = newWord.charAt(i);
                for(char j='a';j<='z';j++){
                    wordArr[i] = j;
                    String temp = new String(wordArr);
                    if(set.contains(temp)){
                        q.add(new Pair(temp,newVal+1));
                    }
                    set.remove(temp);
                }
                wordArr[i] = original;
            }
        }
        return 0;
    }
}