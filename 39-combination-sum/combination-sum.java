class Solution {
    public void backtrack(int[] candidates, int target,int idx,List<Integer> sum,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(sum));
            return;
        }
        if(target<0) return;
        for(int i=idx;i<candidates.length;i++){
            sum.add(candidates[i]);
            backtrack(candidates,target - (candidates[i]),i,sum,result);
            sum.remove(sum.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),result);
        return result;
    }
}