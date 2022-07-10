// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        Node n1 = first;
        Node n2 = second;
        int c1 = 0;
        int c2 = 0;
        while(n1!=null){
            c1++;
            n1=n1.next;
        }
        while(n2!=null){
            c2++;
            n2=n2.next;
        }
        int x = 0;
        if(c1==c2){
            x=solve(first,second);
        }else if(c1<c2){
            Node ptr = first;
            while(c1!=c2){
                Node temp = new Node(0);
                temp.next = ptr;
                ptr = temp;
                c1++;
            }
            first = ptr;
            x=solve(first,second);
        }else if(c1>c2){
            Node ptr = second;
            while(c1!=c2){
                Node temp = new Node(0);
                temp.next = ptr;
                ptr = temp;
                c2++;
            }
            second = ptr;
            x=solve(first,second);
        }
        // n1 = first;
        // n2 = second;
        // while(n1!=null){
        //     System.out.print(n1.data+" ");
        //     n1=n1.next;
        // }
        // System.out.println();
        // while(n2!=null){
        //     System.out.print(n2.data+" ");
        //     n2=n2.next;
        // }
        // System.out.println();
        if(x>0){
            Node t1 = new Node(x);
            t1.next = first;
            first = t1;
        }
        return first;
    }
    public static int solve(Node n1,Node n2){
        if(n1.next==null && n2.next==null){
            if(n1.data+n2.data>9){
                int x = (n1.data+n2.data);
                n1.data = (x)%10;
                x=x/10;
                return x%10;
            }else{
                n1.data = n1.data+n2.data;
                return 0;
            }
        }
        int x = solve(n1.next,n2.next);
        if(x>0){
            if(n1.data+n2.data+x>9){
                int z = n1.data+n2.data+x;
                n1.data = (z)%10;
                z=z/10;
                return z%10;
            }else{
                n1.data = n1.data+n2.data+x;
                return 0;
            }
        }else{
            if(n1.data+n2.data>9){
                int z = n1.data+n2.data;
                n1.data = (z)%10;
                z=z/10;
                return z%10;
            }else{
                n1.data=n1.data+n2.data;
            }
            return 0;
        }
    }
}