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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> hm = new HashMap<>();
        return solve(root,hm);
    }
    public static int solve(TreeNode root,HashMap<TreeNode,Integer> hm){
        if(root==null){
            return 0;
        }
        if(hm.containsKey(root)){
            return hm.get(root);
        }
        int x=0;
        if(root.left!=null){
            x += solve(root.left.left,hm)+solve(root.left.right,hm);
        }
        if(root.right!=null){
            x += solve(root.right.left,hm)+solve(root.right.right,hm);
        }
        x = Math.max(x+root.val, solve(root.left,hm)+solve(root.right,hm));
        hm.put(root,x);
        return x;
    }
}