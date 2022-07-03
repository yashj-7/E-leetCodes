// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        List<String> list = new ArrayList<>();
        solve(list,dict,s,0,"");
        return list;
    }
    public static void solve(List<String> list,List<String> dict,String s,int i,String ans){
        if(i==s.length()){
            ans = ans.trim();
            list.add(ans);
            return ;
        }
        for(int x=i;x<s.length();x++){
            if(dict.contains(s.substring(i,x+1))){
                String temp = ans;
                ans = ans+s.substring(i,x+1);
                ans = ans+" ";
                solve(list,dict,s,x+1,ans);
                ans = temp;
            }
        }
    }
}