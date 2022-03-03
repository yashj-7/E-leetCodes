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
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(0,preorder.length-1,preorder);
    }
    public TreeNode solve(int start,int end,int[] preorder){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int i;
        for(i=start;i<=end;i++){
            if(preorder[i]>root.val){
                break;
            }
        }
        root.left = solve(start+1,i-1,preorder);
        root.right = solve(i,end,preorder);
        return root;
    }
}