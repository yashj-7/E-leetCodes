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
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode predecessor = find(curr);
                if(predecessor.right==null){
                    predecessor.right = curr;
                    curr = curr.left;
                }else{
                    predecessor.right = null;
                    list.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return list;
    }
    public TreeNode find(TreeNode root){
        TreeNode temp = root.left;
        while(temp.right!=null && temp.right!=root){
            temp = temp.right;
        }
        return temp;
    }
}