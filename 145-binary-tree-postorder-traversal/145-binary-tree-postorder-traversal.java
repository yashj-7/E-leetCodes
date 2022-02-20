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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        solve(list,root);
        return list;
    }
    public List<Integer> solve(List<Integer> list,TreeNode root){
        if(root==null){
            return list;
        }
        solve(list,root.left);
        solve(list,root.right);
        list.add(root.val);
        return list;
    }
}