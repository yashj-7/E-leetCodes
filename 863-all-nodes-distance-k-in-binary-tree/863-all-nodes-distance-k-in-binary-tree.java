/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        HashSet<TreeNode> hs = new HashSet<>();
        findAncestors(root,target,list1,list2);
        NodeToBottom(hs,target,list,k);
        hs.add(target);
        for(int i=0;i<list2.size();i++){
            if(hs.contains(list2.get(i))==false){
                NodeToBottom(hs,list2.get(i),list,k-(i+1));
                hs.add(list2.get(i));
            }     
        }
        for(int i=0;i<list2.size();i++){
            System.out.print(list2.get(i).val+" ");
        }
        return list;
    }
    public void findAncestors(TreeNode root,TreeNode target,List<TreeNode> list,List<TreeNode> list1){
        if(root==null){
            return;
        }
        if(root.val==target.val){
            for(int i=0;i<list.size();i++){
                list1.add(list.get(i));
            }
            return;
        }
        list.add(0,root);
        findAncestors(root.left,target,list,list1);
        findAncestors(root.right,target,list,list1);
        list.remove(0);
    }
    public void NodeToBottom(HashSet<TreeNode> hs,TreeNode root,ArrayList<Integer> list,int k){
        if(root==null){
            return;
        }
        if(hs.contains(root)==true){
            return;
        }
        if(k==0){
            list.add(root.val);
        }
        NodeToBottom(hs,root.left,list,k-1);
        NodeToBottom(hs,root.right,list,k-1);
    }
}