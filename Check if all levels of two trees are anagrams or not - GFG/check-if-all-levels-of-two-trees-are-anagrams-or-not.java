// { Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        
        // Creating array of Strings from input 
        // String after spliting by space
        String ip[] = str.split(" ");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N"))
            {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N"))
            {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }
    
    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node node1 = Node.inputTree(br);
            
            
            Node node2 = Node.inputTree(br);
            
            Solution obj = new Solution();
            boolean res = obj.areAnagrams(node1, node2);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}
// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static boolean areAnagrams(Node node1, Node node2) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> mList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> mList2 = new ArrayList<>();
        
        q1.add(node1);
        q1.add(null);
        while(q1.isEmpty()==false){
          Node n1 = q1.poll();
          if(n1!=null && n1.left!=null){
              q1.add(n1.left);
          }
          if(n1!=null && n1.right!=null){
              q1.add(n1.right);
          }
          if(n1==null){
              if(q1.size()!=0){
                  q1.add(null);
              }
              list1.add(Integer.MAX_VALUE);
          }else{
              list1.add(n1.data);
          }
          
        }
        q2.add(node2);
        q2.add(null);
         while(q2.isEmpty()==false){
          Node n1 = q2.poll();
          if(n1!=null && n1.left!=null){
              q2.add(n1.left);
          }
          if(n1!=null && n1.right!=null){
              q2.add(n1.right);
          }
          if(n1==null){
              if(q2.size()!=0){
                  q2.add(null);
              }
              list2.add(Integer.MAX_VALUE);
          }else{
              list2.add(n1.data);
          }
          
        }
        
        ArrayList<Integer> l1 =new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)==Integer.MAX_VALUE){
                mList.add(new ArrayList<>(l1));
                l1.clear();
            }else{
                l1.add(list1.get(i));
            }
        }
        for(int i=0;i<list2.size();i++){
            if(list2.get(i)==Integer.MAX_VALUE){
                mList2.add(new ArrayList<>(l2));
                l2.clear();
            }else{
                l2.add(list2.get(i));
            }
        }
        
        for(int i=0;i<mList.size();i++){
            ArrayList<Integer> lis1 = mList.get(i);
            ArrayList<Integer> lis2 = mList2.get(i);
            Collections.sort(lis1);
            Collections.sort(lis2);
            if(lis1.equals(lis2)==false){
                return false;
            }
        }
        // System.out.println(mList);
        // System.out.println(mList2);
        return true;
    }
}
        
