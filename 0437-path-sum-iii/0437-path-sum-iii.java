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
    public int pathSum(TreeNode root, int targetSum) {
        int ans = 0;
        if(root==null){
            return 0;
        }
        // if(targetSum==0){
        //     Queue<TreeNode> q = new LinkedList<>();
        //     int count = 0 ;
        //     q.offer(root);
        //     while(q.isEmpty()==false){
        //         TreeNode n = q.poll();
        //         if(n.val==0){
        //             count++;
        //         }
        //         if(n.left!=null){
        //             q.offer(n.left);
        //         }
        //         if(n.right!=null){
        //             q.offer(n.right);
        //         }
        //     }
        //     return count;
        // }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.isEmpty()==false){
            TreeNode n = q.poll();
            ans+=helper(n,targetSum);
            //System.out.println(n.val+"-->"+ans);
            if(n.left!=null){
                q.offer(n.left);
            }
            if(n.right!=null){
                q.offer(n.right);
            }
        }
        return ans;
    }
    public static int helper(TreeNode root,long targetSum){
        // if(targetSum==0){
        //     return 1;
        // }
        if(root==null){
            return 0;
        }
        int ans=0;
        if(root.val==targetSum){
            ans= 1;
        }
        // int ans= 0;
        // if(root.val<targetSum){
            ans+=helper(root.left,targetSum-root.val);
            ans+=helper(root.right,targetSum-root.val);
        //}
        return ans;
    }
}