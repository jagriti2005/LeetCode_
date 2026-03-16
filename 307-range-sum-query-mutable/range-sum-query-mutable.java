class NumArray {
    int[] arr,segment;
    public NumArray(int[] nums) {
        arr = nums;
        int n = nums.length;
        segment = new int[4*n];
        buildTree(0,0,n-1);
    }
    public void buildTree(int i, int s, int e){
        if(s==e){
            segment[i] = arr[s];
            return;
        }
        int mid = (s+e)/2;
        buildTree(2*i+1,s,mid);
        buildTree(2*i+2,mid+1,e);
        segment[i] = segment[2*i+1] + segment[2*i+2];
    } 
    public void updateTree(int idx, int val, int i, int s, int e){
        if(s==e){
            segment[i] = val;
            return;
        }
        int mid = (s+e)/2;
        if(idx <= mid) updateTree(idx,val,2*i+1,s,mid);
        else updateTree(idx,val,2*i+2,mid+1,e);
        segment[i] = segment[2*i+1] + segment[2*i+2];
    }
    public void update(int index, int val) {
        int n = arr.length;
        updateTree(index,val,0,0,n-1);
    }
    
    public int rangeSum(int i, int l, int r, int s, int e){
        //complete overlap
        if(l<=s && r>=e) return segment[i];

        //no overlap
        if(r<s || l>e) return 0;

        // partial overlap
        int mid = (s+e)/2;
        return rangeSum(2*i+1,l,r,s,mid) + rangeSum(2*i+2,l,r,mid+1,e);
    }

    public int sumRange(int left, int right) {
        int n = arr.length;
        return rangeSum(0,left,right,0,n-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */