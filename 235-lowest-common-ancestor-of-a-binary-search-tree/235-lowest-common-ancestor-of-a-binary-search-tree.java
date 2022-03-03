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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }
    public TreeNode solve(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        if(root==q || root==p){
            return root;
        }
        TreeNode temp1 = solve(root.left,p,q);
        TreeNode temp2 = solve(root.right,p,q);
        if(temp1!=null && temp2!=null){
            return root;
        }
        if(temp1!=null){
            return temp1;
        }
        return temp2;
    }
}