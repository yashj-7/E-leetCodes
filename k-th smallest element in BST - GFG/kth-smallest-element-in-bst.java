// { Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currrNode = q.remove();

            // Get the currrent node's value from the string
            String currrVal = s[i];

            // If the left child is not null
            if (!currrVal.equals("N")) {

                // Create the left child for the currrent node
                currrNode.left = new Node(Integer.parseInt(currrVal));

                // Push it to the queue
                q.add(currrNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currrVal = s[i];

            // If the right child is not null
            if (!currrVal.equals("N")) {

                // Create the right child for the currrent node
                currrNode.right = new Node(Integer.parseInt(currrVal));

                // Push it to the queue
                q.add(currrNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine().trim());

            Solution T = new Solution();
            System.out.println(T.KthSmallestElement(root, k));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//           public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    
    public int KthSmallestElement(Node root, int K) {
        // int x = count(root);
        // if(x<k){
        //     return -1;
        // }
        int[] arr = new int[1];
        solve(root,K,arr);
        return arr[0]==0?-1:arr[0];
    }
    public static void solve(Node root,int k,int[] arr){
        if(root==null){
            return;
        }
        //System.out.println(k);
        int x = 1+count(root.left);
        if(x==k){
           // System.out.println("running");
            arr[0] = root.data;
            return;
        }
        if(x>k){
            solve(root.left,k,arr);
        }
        if(x<k){
            solve(root.right,k-x,arr);
        }
    }
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int t1 = 1+count(root.left)+count(root.right);
        return t1;
    }
}
