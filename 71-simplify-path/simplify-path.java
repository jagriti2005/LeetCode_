class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] s = path.split("/");
        for(String dir : s){
            if(dir.isEmpty() || dir.equals(".")) continue;
            if(dir.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else st.push(dir);
        }

        StringBuilder sb = new StringBuilder();
        for(String dir:st){
            sb.append("/").append(dir);
        }
        return sb.length()==0 ? "/" : sb.toString();
    }
}