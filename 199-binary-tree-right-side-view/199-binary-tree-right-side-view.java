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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        while(q.isEmpty()==false){
            TreeNode n = q.poll();
            if(n!=null && q.peek()==null){
                list.add(n.val);
            }
            if(n==null && q.isEmpty()==false){
                q.offer(null);
            }
            if(n!=null && n.left!=null){
                q.offer(n.left);
            }
            if(n!=null && n.right!=null){
                q.offer(n.right);
            }
            
        }
        return list;
    }
}