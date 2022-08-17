/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        if(root.left==null && root.right==null){
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        if(root.left!=null){
           q.offer(root.left); 
        }
        
        if(root.right!=null){
           q.offer(root.right); 
        }
        while(q.isEmpty()==false){
            int n = q.size();
            Node n1 = null;
            for(int i=0;i<n;i++){
               if(i==0){
                   n1 = q.poll();
                   if(n1.left!=null){
                       q.offer(n1.left);
                   }
                   if(n1.right!=null){
                       q.offer(n1.right);
                   }
               }else{
                   n1.next = q.poll();
                   n1 = n1.next;
                   if(n1.left!=null){
                       q.offer(n1.left);
                   }
                   if(n1.right!=null){
                       q.offer(n1.right);
                   }
               }
            }
        }
        return root;
    }
}