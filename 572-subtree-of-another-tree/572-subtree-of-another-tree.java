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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(preorder(root,subRoot)){
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    
    public static boolean preorder(TreeNode root,TreeNode subRoot){
        if(root==null){
            if(subRoot==null){
                return true;
            }
            return false;
        }
        if(subRoot==null){
            return false;
        }
        if(root.val!=subRoot.val){
            return false;
        }
       boolean t1 = preorder(root.left,subRoot.left);
       boolean t2 = preorder(root.right,subRoot.right);
        return t1 && t2;
    }
    
    public static TreeNode getNode(TreeNode root,TreeNode subRoot){
        if(root==null){
            return null;
        }
        if(root.val == subRoot.val){
            return root;
        }
        TreeNode n1 = getNode(root.left,subRoot);
        TreeNode n2 = getNode(root.right,subRoot);
        if(n1!=null){
            return n1;
        }
        return n2;
    }
}