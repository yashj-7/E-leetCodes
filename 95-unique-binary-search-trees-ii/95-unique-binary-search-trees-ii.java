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
    public List<TreeNode> generateTrees(int n) {
        return solve(1,n);
    }
    public static List<TreeNode> solve(int i,int j){
        if(i>j){
            List<TreeNode> b = new ArrayList<>();
            b.add(null);
            return b;
        }
        List<TreeNode> list = new ArrayList<>();
        for(int x=i;x<=j;x++){
            List<TreeNode> left = solve(i,x-1);
            List<TreeNode> right = solve(x+1,j);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(x);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list; 
    }
}