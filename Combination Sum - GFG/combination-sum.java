// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        Collections.sort(A);
        solve(list,temp,A,B,0,hs);
        
        //Collections.sort(list,Collections.reverseOrder());
        return list;
    }
    public static void solve(ArrayList<ArrayList<Integer>> list,ArrayList<Integer> temp,ArrayList<Integer> A,int B,int i,HashSet<ArrayList<Integer>> hs){
        if(i>=A.size()){
            return;
        }
        if(B==0){
            if(hs.contains(temp)){
                return;
            }
            hs.add(temp);
            list.add(new ArrayList<>(temp));
            return;
        }
        if(A.get(i)<=B){
            temp.add(A.get(i));
            solve(list,temp,A,B-A.get(i),i,hs);
            temp.remove(temp.size()-1);
            solve(list,temp,A,B,i+1,hs);
        }else{
            solve(list,temp,A,B,i+1,hs);
        }
    }
}