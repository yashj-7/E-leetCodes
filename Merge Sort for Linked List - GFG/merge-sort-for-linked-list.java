// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    static Node mergeSort(Node head)
    {
        Node first = head;
        Node last = head;
        while(last.next!=null){
            last=last.next;
        }
        return solve(first,last);
    }
    public static Node solve(Node first,Node last){
        if(first==last){
            Node n = new Node(first.data);
            return n;
        }
        Node x = findMid(first,last);
        Node i = solve(first,x);
        Node j = solve(x.next,last);
        return merge(i,j);
    }
    public static Node findMid(Node first,Node last){
        Node f = first;
        Node s = first;
        while(f!=last && f.next!=last){
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
    public static Node merge(Node i,Node j){
        Node temp = new Node(-1);
        Node ret = temp;
        Node x1 = i;
        Node x2 = j;
        while(x1!=null && x2!=null){
            Node t1 = new Node(-1);
            if(x1.data<=x2.data){
                t1.data = x1.data;
                temp.next = t1;
                temp = temp.next;
                x1=x1.next;
            }else if(x1.data>x2.data){
                t1.data = x2.data;
                temp.next = t1;
                temp = temp.next;
                x2=x2.next;
            }
        }
        while(x1!=null){
            Node t1 = new Node(-1);
            t1.data = x1.data;
            temp.next = t1;
            temp = temp.next;
            x1 = x1.next;
        }
        while(x2!=null){
            Node t1 = new Node(-1);
            t1.data = x2.data;
            temp.next = t1;
            temp = temp.next;
            x2 = x2.next;
        }
        return ret.next;
    }
}


