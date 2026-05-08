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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (q.size() > 0) {
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            while(size > 0){
                TreeNode curr = q.poll();
                list.add(curr);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                size--;
            }
            if (level % 2 == 1) {
                int i = 0;
                int j = list.size() - 1;
                while (i < j) {
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(j).val;
                    list.get(j).val = temp;
                    i++;
                    j--;
                }
            }

            level++;
        }

        return root;
    }
}