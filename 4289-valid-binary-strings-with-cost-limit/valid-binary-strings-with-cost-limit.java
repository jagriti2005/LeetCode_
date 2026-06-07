class Solution {
    public void backtrack(List<String> ans, StringBuilder sb,int i,int cost,int n, int k){
        if(i==n){
            ans.add(sb.toString());
            return;
        }

        sb.append('0');
        backtrack(ans,sb,i+1,cost,n,k);
        sb.deleteCharAt(sb.length()-1);

        if(sb.length()==0 || sb.charAt(sb.length()-1) != '1'){
            int newCost = cost+i;
            if(newCost <= k){
                sb.append('1');
                backtrack(ans,sb,i+1,newCost,n,k);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,new StringBuilder(),0,0,n,k);
        return ans;
    }
}