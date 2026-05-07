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
    public boolean isSubset(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null) return false;

        if(r1.val != r2.val) return false;
        
        boolean Left = isSubset(r1.left,r2.left);
        boolean Right = isSubset(r1.right,r2.right);
        return Left && Right;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null || subRoot==null) return false;

        if(isSubset(root,subRoot)) return true;
        boolean Left = isSubtree(root.left,subRoot);
        boolean Right = isSubtree(root.right, subRoot);
        return Left || Right;
    }
}