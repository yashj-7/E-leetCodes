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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        List<Integer> temp = new ArrayList<>();
        // temp.add(root.val);
        // ans.add(new ArrayList<>(temp));
        // temp.clear();
        q.offer(null);
        while(q.isEmpty()==false){
            TreeNode n = q.poll();
            
            if(n==null && q.isEmpty()==false){
                ans.add(0,new ArrayList<>(temp));
                temp.clear();
                q.offer(null);
            }
            if(n!=null){
                temp.add(n.val);
            }
            
            if(n!=null && n.left!=null){
                q.offer(n.left);
            }
            if(n!=null && n.right!=null){
                q.offer(n.right);
            }
            
        }
        if(temp.size()>0){
            ans.add(0,new ArrayList<>(temp));
        }
        return ans;
    }
}