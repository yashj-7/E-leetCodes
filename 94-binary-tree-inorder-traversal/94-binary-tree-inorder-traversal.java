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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        solve(list,root);
        return list;
    }
    public List<Integer> solve(List<Integer> list,TreeNode root){
        if(root==null){
            return list;
        }
        solve(list,root.left);
        list.add(root.val);
        solve(list,root.right);
        return list;
    }
}