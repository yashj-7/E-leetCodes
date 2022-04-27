// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String input[] = br.readLine().trim().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution g = new Solution();
                Node k = g.lca(root,a,b);
    			System.out.println(k.data);
    	        
	        }
	}
}
// } Driver Code Ends


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution
{
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2)
	{
		ArrayList<Node> list1 = new ArrayList<>();
		ArrayList<Node> list2 = new ArrayList<>();
		solve(root,n1,list1);
		solve(root,n2,list2);
// 		for(int i=0;i<list1.size();i++){
// 		    System.out.print(list1.get(i).data+" ");
// 		}
// 		System.out.println();
// 		for(int i=0;i<list2.size();i++){
// 		    System.out.print(list2.get(i).data+" ");
// 		}
		for(int i =0;i<Math.max(list1.size(),list2.size());i++){
		    if(i>=list1.size() || i>=list2.size() || list1.get(i).data != list2.get(i).data){
		        return list1.get(i-1);
		    }
		}
		return root;
	}
	public static boolean solve(Node root,int n,ArrayList<Node> list){
	    if(root==null){
	        return false;
	    }
	    list.add(root);
	    if(root.data == n){
	        return true;
	    }
	    boolean t1 = false;
	    boolean t2 = false;
	    if(root.left!=null){
	       t1= solve(root.left,n,list);
	    }
	    if(root.right!=null){
	        t2 = solve(root.right,n,list);
	    }
	    if(t1||t2 == true){
	        return true;
	    }
	    list.remove(list.size()-1);
	    return false;
	}
}

