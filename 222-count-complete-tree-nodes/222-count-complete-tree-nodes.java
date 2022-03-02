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
    public int countNodes(TreeNode root) {
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);
        if(lh==rh){
            return (int)Math.pow(2,lh)-1;
        }
           return 1+countNodes(root.left)+countNodes(root.right);
    }
    public static int findRightHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int count = 0;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count+1;
    }
    public static int findLeftHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int count = 0;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count+1;
    }
}