/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                size--;
            }
            res.add(list);
        }
        return res;
    }
    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> list = levelOrder(root);
        int[] max = new int[list.size()];
        for(int i=0;i<list.size();i++){
            int sum = 0;
            for(int num:list.get(i)){
                sum += num;
            }
            max[i] = sum;
        }

        int maxSum = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=0;i<list.size();i++){
            if(max[i] > maxSum){
                maxSum = max[i];
                idx = i;
            }
        }
        return idx+1;
    }
}