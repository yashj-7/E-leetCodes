// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Sol obj = new Sol();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        Node n1 = head1;
        Node n2 = head2;
        while(n1!=null){
            if(hm.containsKey(n1.data)==false){
                hm.put(n1.data,1);
            }else{
                int x = hm.get(n1.data);
                hm.put(n1.data,x+1);
            }
            n1=n1.next;
        }
        Node start = new Node(-1);
        Node res = start;
        //System.out.println(hm);
        while(n2!=null){
            if(hm.containsKey(n2.data)&&hm.get(n2.data)>0){
                Node n = new Node(n2.data);
                start.next = n;
                start = start.next;
                int x = hm.get(n2.data);
                hm.put(n2.data,x-1);
            }
            n2 = n2.next;
        }
        return res.next;
    }
}