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
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        solve("",root,list);
        int ans = 0;
        for(int i=0;i<list.size();i++){
            ans = ans+list.get(i);
        }
        // System.out.println(list);
        return ans;
    }
    public static void solve(String s,TreeNode root,ArrayList<Integer> list){
        if(root.left==null && root.right==null){
            s=s+root.val;
            list.add(Integer.parseInt(s));
            return;
        }
        s=s+String.valueOf(root.val);
        if(root.left!=null){
            solve(s,root.left,list);
        }
        if(root.right!=null){
            solve(s,root.right,list);
        }
    }
}