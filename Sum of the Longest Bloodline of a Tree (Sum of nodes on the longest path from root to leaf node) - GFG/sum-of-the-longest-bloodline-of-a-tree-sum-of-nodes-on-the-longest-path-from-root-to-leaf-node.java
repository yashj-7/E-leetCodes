// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
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
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int res = obj.sumOfLongRootToLeafPath(root);
		    System.out.println(res);
		}
	}
}// } Driver Code Ends


//User function Template for Java

/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    public int sumOfLongRootToLeafPath(Node root)
    {
        int[] ans = new int[2];
        ans = solve(root,0);
        return ans[0];
    }
    public static int[] solve(Node root,int level){
        if(root.left==null && root.right==null){
            int[] arr = new int[2];
            arr[0] = root.data;
            arr[1] = level;
            return arr;
        }
        int[] arr = new int[2];
        int[] tmp1 = new int[2];
        int[] tmp2 = new int[2];
        if(root.left!=null){
            tmp1 = solve(root.left,level+1);
        }
        if(root.right!=null){
            tmp2 = solve(root.right,level+1);
        }
        
        if(tmp1[1]>tmp2[1]){
            arr[0] = root.data+tmp1[0];
            arr[1] = tmp1[1];
        }else if(tmp1[1]<tmp2[1]){
            arr[0] = root.data+tmp2[0];
            arr[1] = tmp2[1];
        }else {
            if(tmp1[0]>tmp2[0]){
                arr[0] = root.data+tmp1[0];
                arr[1] = tmp1[1];
            }else{
                arr[0] = root.data+tmp2[0];
                arr[1] = tmp2[1];
            }
        }
        return arr;
    }
}