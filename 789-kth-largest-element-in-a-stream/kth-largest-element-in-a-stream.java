class KthLargest {
    PriorityQueue<Integer> pq;
    int givenK;
    public KthLargest(int k, int[] nums) {
        givenK = k;
        pq = new PriorityQueue<>();
        for(int n:nums){
            pq.add(n);
            if(pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > givenK) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */