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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean alt = true;
        while(q.isEmpty()==false){
            ArrayList<Integer> list2 = new ArrayList<>();
            TreeNode t = q.peek();
            int x = q.size();
                if(alt==true){
                    for(int i=0;i<x;i++){
                        TreeNode y = q.poll();
                        if(y.left!=null){
                            q.offer(y.left);
                        }
                        if(y.right!=null){
                            q.offer(y.right);
                        }
                        list2.add(y.val);    
                    }
                }else{
                    int j=x;
                    while(j>0){
                        TreeNode y = q.poll();
                        if(y.left!=null){
                            q.offer(y.left);
                        }
                        if(y.right!=null){
                            q.offer(y.right);
                        }
                        list2.add(0,y.val);
                        j--;
                    }
                }
            list.add(list2);
            alt = !alt;
        }
        return list;
    }
}