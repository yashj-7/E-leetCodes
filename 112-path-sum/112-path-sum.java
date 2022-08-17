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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root,targetSum);   
    }
    public static boolean solve(TreeNode root,int sum){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            if(root.val==sum){
                return true;
            }else{
                return false;
            }
        }
        // if(sum<=0){
        //     return false;
        // }
        boolean t1 = false;
        boolean t2 = false;
        if(root.left!=null){
            t1 = solve(root.left,sum-root.val);
        }
        if(root.right!=null){
            t2 = solve(root.right,sum-root.val);
        }
        return t1||t2;
    }
}