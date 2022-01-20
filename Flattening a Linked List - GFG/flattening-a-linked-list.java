// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
	if(root.next==null){
	    return root;
	}
	Node newNode = flatten(root.next);
	Node res = merge(root,newNode);
	res.next=null;
	return res;
    }
    public Node merge(Node n1,Node n2){
        Node temp = new Node(0);
        if(n1.data<=n2.data){
            temp = n1;
            temp.data = n1.data;
        }else{
            temp = n2;
            temp.data = n2.data;
        }
        Node res = temp;
        Node t1 = n1;
        Node t2 = n2;
        int i=0;
        while(t1!=null && t2!=null){
            if(i==0){
                if(t1.data<=t2.data){
                    temp = t1;
                    t1 = t1.bottom;
                }else{
                    temp = t2;
                    t2 = t2.bottom;
                }
                i=1;
                continue;
            }
            if(t1.data<=t2.data){
                temp.bottom = t1;
                t1 = t1.bottom;
            }else if(t2.data<t1.data){
                temp.bottom = t2;
                t2 = t2.bottom;
            }
            temp = temp.bottom;
        }
        if(t1==null && t2!=null){
            while(t2!=null){
                temp.bottom = t2;
                t2 = t2.bottom;
                temp = temp.bottom;
            }
        }
        if(t1!=null && t2==null){
            while(t1!=null){
                temp.bottom = t1;
                t1 = t1.bottom;
                temp = temp.bottom;
            }
        }
        temp.bottom = null;
        return res;
    }
}