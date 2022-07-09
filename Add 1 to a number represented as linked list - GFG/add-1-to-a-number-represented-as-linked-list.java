// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        int x = solve(head);
        if(x==1){
            head.data = 10;
        }
        return head;
    }
    public static int solve(Node temp){
        if(temp.next==null){
            if(temp.data+1>9){
                temp.data = 0;
                return 1;
            }
            temp.data = temp.data+1;
            return 0;
        }
       int x = solve(temp.next);
       if(x==1){
           if(temp.data+1>9){
               temp.data=0;
               return 1;
           }else{
               temp.data = temp.data+1;
           }
       }
       return 0;
    }
}
