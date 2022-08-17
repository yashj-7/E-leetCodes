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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(root,list,temp,targetSum);
        return list;
    }
    public static void solve(TreeNode root,List<List<Integer>> list, List<Integer> temp,int targetSum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(targetSum==root.val){
                temp.add(root.val);
                list.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
                return;
            }else{
                return;
            }
        }
        // if(targetSum==0){
        //     return;
        // }
        temp.add(root.val);
        if(root.left!=null){
            solve(root.left,list,temp,targetSum-root.val);
        }
        if(root.right!=null){
            solve(root.right,list,temp,targetSum-root.val);
        }
        temp.remove(temp.size()-1);
    }
}