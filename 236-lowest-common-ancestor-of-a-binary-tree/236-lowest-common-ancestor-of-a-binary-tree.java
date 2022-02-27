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
        if(root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode temp = solve(root.left,p,q);
        TreeNode temp2 = solve(root.right,p,q);
        if(temp!=null && temp2!=null){
            return root;
        }else if(temp!=null){
            return temp;
        }
        return temp2;
    }
}