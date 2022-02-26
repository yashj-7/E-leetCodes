
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        findDepth(root,max);
        return max[0];
    }
    public int findDepth(TreeNode root,int[] max){
        if(root==null){
            return 0;
        }
        int d1 = findDepth(root.left,max);
        int d2 = findDepth(root.right,max);
        max[0] = Math.max(max[0],d1+d2);
        return 1+Math.max(d1,d2);
    }
}