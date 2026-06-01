/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isExist(TreeNode root,TreeNode node){
        if(root == null) return false;
        if(root == node) return true;
        return isExist(root.left,node) || isExist(root.right,node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root) return root;
        boolean pLST = isExist(root.left,p);
        boolean qLST = isExist(root.left,q);

        if(pLST==true && qLST==true) return lowestCommonAncestor(root.left,p,q);
        if(pLST==false && qLST==false) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
}