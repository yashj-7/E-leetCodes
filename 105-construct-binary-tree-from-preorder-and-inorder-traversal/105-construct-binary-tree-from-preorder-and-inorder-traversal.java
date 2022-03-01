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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(0,0,preorder.length-1,preorder,inorder);
    }
    public TreeNode solve(int prestart,int instart,int inend, int[] preorder,int[] inorder){
        if(prestart>preorder.length-1 || instart>inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int index = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                index = i;
            }
        }
        root.left = solve(prestart+1,instart,index-1,preorder,inorder);
        root.right = solve(prestart+index-instart+1,index+1,inend,preorder,inorder);
        return root;
    }
}