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
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
    public TreeNode solve(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode();
        int mid = (start+end)/2;
        root.val = nums[mid];
        root.left = solve(nums,start,mid-1);
        root.right = solve(nums,mid+1,end);
        return root;
    }
}