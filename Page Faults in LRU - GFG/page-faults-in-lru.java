// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[]= new int[N];
            for(int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.pageFaults(N, C, pages));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static class Node{
        int data;
        Node prev;
        Node next;
        Node(int data,Node prev,Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    static int pageFaults(int N, int capacity, int pages[]){
        HashMap<Integer,Node> hm = new HashMap<>();
        Node start = new Node(-1,null,null);
        Node end = new Node(-1,start,null);
        start.next = end;
        int pf = 0;
        int cap = 0;
        for(int i=0;i<N;i++){
            if(hm.containsKey(pages[i])==false){
                if(cap<capacity){
                    Node n = new Node(pages[i],null,null);
                    n.next = end;
                    n.prev = end.prev;
                    end.prev.next = n;
                    end.prev = n;
                    hm.put(pages[i],n);   
                    cap++;
                }else{
                    int x = start.next.data;
                    start.next.next.prev = start;
                    start.next = start.next.next;
                    hm.remove(x);
                    Node n = new Node(pages[i],null,null);
                    n.next = end;
                    n.prev = end.prev;
                    end.prev.next = n;
                    end.prev = n;
                    hm.put(pages[i],n);
                }
                pf++;
            }else{
               Node x = hm.get(pages[i]);
                    x.prev.next = x.next;
                   x.next.prev = x.prev;  
                   x.next = end;
                   x.prev = end.prev;
                   end.prev.next = x;
                   end.prev = x;
            }
        }
        return pf;
    }
}