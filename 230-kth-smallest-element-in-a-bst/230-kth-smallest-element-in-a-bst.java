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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] count = new int[1];
        count[0] = 0;
        solve(root,k,count,arr);
        return arr.get(0);
    }
    public void solve(TreeNode root,int k,int[] count,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        solve(root.left,k,count,arr);
        count[0]=count[0]+1;
        if(count[0]==k){
            arr.add(root.val);
        }
        solve(root.right,k,count,arr);
    }
}