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
    static int s = 0;
    public TreeNode bstToGst(TreeNode root) {
        int x = sum(root);
        System.out.println(x);
        helper(root,x);
        s=0;
        return root;
    }
    public static int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        int x = 0;
        x=x+sum(root.left);
        x=x+root.val;
        x=x+sum(root.right);
        return x;
    }
    public static void helper(TreeNode root,int total){
        if(root==null){
            return ;
        }
        helper(root.left,total);
        int y = root.val;
        root.val = total-s;
        s=s+y;
        helper(root.right,total);
    }
}