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
    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        findDepth(root,ans);
        return ans[0];
    }
    public int findDepth(TreeNode root,boolean[] ans){
        if(root==null){
            return 0;
        }
        int d1 = findDepth(root.left,ans);
        int d2 = findDepth(root.right,ans);
        if(Math.abs(d1-d2)>1){
            //System.out.print(root.val);
            ans[0] = false;
        }
        return 1+Math.max(d1,d2);
    }
}