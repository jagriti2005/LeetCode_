class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n:stones) pq.add(n);
        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            if(x != y) pq.add(x-y);
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}