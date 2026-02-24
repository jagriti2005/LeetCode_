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
// class Solution {
//     public void invert(TreeNode root){
//         if(root==null) return;
//         TreeNode temp = root.left;
//         root.left = root.right;
//         root.right = temp;
//         invert(root.left);
//         invert(root.right);
//     }
//     public boolean sameTree(TreeNode p, TreeNode q){
//         if(p==null && q==null) return true;
//         if(p==null || q==null) return false;

//         return (p.val == q.val) && sameTree(p.left,q.left) && sameTree(p.right,q.right);
//     }
//     public boolean isSymmetric(TreeNode root) {
//         invert(root.left);
//         return sameTree(root.left,root.right);
//     }
// }

class Solution {
    public boolean isMirror(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null||q==null) return false;
        return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
}