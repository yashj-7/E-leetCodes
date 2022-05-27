// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
    static class info{
        int maxi;
        int mini;
        int size;
        boolean isBst;
        info(){
            
        }
        info(int maxi,int mini,int size,boolean isBst){
            this.maxi = maxi;
            this.mini = mini;
            this.size = size;
            this.isBst = isBst;
        }
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        return traverse(root).size;
    }
    public static info traverse(Node root){
        if(root==null){
            return new info(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        }
        if(root.left==null && root.right==null){
            return new info(root.data,root.data,1,true);
        }
        info curr = new info();
        info left = traverse(root.left);
        info right = traverse(root.right);
        if(left.isBst==true && right.isBst==true && (left.maxi<root.data && right.mini>root.data)){
            curr.size = left.size+right.size+1;
            curr.maxi = Math.max(root.data,Math.max(left.maxi,right.maxi));
            curr.mini = Math.min(root.data,Math.min(left.mini,right.mini));
            curr.isBst = true;
        }else{
            curr.mini = Integer.MAX_VALUE;
            curr.maxi = Integer.MIN_VALUE;
            curr.size = Math.max(left.size,right.size);
            curr.isBst = false;
        }
        return curr;
    }
    
}