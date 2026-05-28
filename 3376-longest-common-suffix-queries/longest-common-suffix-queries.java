class Solution {

    class Node {
        Node[] next = new Node[26];
        int index = -1;
        int size = Integer.MAX_VALUE;
    }

    Node root = new Node();

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        int minSize = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < minSize) {
                minSize = wordsContainer[i].length();
                minIndex = i;
            }
        }

        root.index = minIndex;
        root.size = minSize;

        for (int i = 0; i < wordsContainer.length; i++) {
            add(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = find(wordsQuery[i]);
        }

        return ans;
    }

    void add(String s, int idx) {

        Node cur = root;

        for (int i = s.length() - 1; i >= 0; i--) {

            int ch = s.charAt(i) - 'a';

            if (cur.next[ch] == null) {
                cur.next[ch] = new Node();
            }

            cur = cur.next[ch];

            if (s.length() < cur.size) {
                cur.size = s.length();
                cur.index = idx;
            }
        }
    }

    int find(String s) {

        Node cur = root;

        for (int i = s.length() - 1; i >= 0; i--) {

            int ch = s.charAt(i) - 'a';

            if (cur.next[ch] == null) {
                break;
            }

            cur = cur.next[ch];
        }

        return cur.index;
    }
}