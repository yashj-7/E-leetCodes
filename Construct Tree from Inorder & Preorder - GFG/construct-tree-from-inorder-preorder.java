// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        return solve(preorder,inorder,0,n-1,0);
    }
    public static Node solve(int[] pre, int[] in,int i,int j,int y){
        if(y>pre.length-1 || i>j){
            return null;
        }
        Node x = new Node(pre[y]);
        int x1 = 0;
        for(int k=0;k<in.length;k++){
            if(in[k]==x.data){
                x1 =k;
            }
        }
        x.left = solve(pre,in,i,x1-1,y+1);
        x.right = solve(pre,in,x1+1,j,y+x1-i+1);
        return x;
    }
}
