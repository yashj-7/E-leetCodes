// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> s = new Stack();
    	for(int i=0;i<M.length;i++){
    	    s.push(i);
    	}
    	while(s.size()>=2){
    	    int x = s.pop();
    	    int y = s.pop();
    	    if(M[x][y]==1 && M[y][x]!=1){
    	        s.push(y);
    	    }
    	    if(M[y][x]==1 && M[x][y]!=1){
    	     s.push(x);   
    	    }
    	}
    	
    	if(s.isEmpty()==true){
    	    return -1;
    	}
    	int j = s.peek();
    	//System.out.println(s.size()+" .");
    	int flag =0;
    	for(int i=0;i<n;i++){
    	    if(M[i][j]==0 && i!=j){
    	        flag=1;
    	    }
    	}
    	
    	for(int i=0;i<n;i++){
    	    if(M[j][i]==1 && i!=j){
    	        flag =1;
    	    }
    	}
    	if(flag==1){
    	    return -1;
    	}
    	return j;
    }
}