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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    public TreeNode solve(int poststart,int instart,int inend,int[] inorder,int[] postorder){
        if(poststart<0 || instart>inend){
            return null;
        }
        int index = 0;
        TreeNode root = new TreeNode(postorder[poststart]);
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                index = i;
            }
        }
        root.left = solve(poststart-inend+index-1,instart,index-1,inorder,postorder);
        root.right = solve(poststart-1,index+1,inend,inorder,postorder);
        return root;
    }
}