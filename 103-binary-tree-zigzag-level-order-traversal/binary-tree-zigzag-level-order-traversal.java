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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean leftToRight = true;

        while(q.size() > 0){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-->0){
                TreeNode curr = q.poll();
                list.add(curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            if(!leftToRight){
                Collections.reverse(list);
            }
            res.add(list);
            leftToRight = !leftToRight;
        }

        return res;
    }
}