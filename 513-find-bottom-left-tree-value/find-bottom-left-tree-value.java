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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size() > 0){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
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
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = levelOrder(root);
        return list.get(list.size() - 1).get(0);
    }
}