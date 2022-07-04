// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        solve(list,temp,s,0);
        return list;
    }
    public static void solve(ArrayList<ArrayList<String>> list,ArrayList<String> temp,String s,int i){
        if(i==s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int x=i;x<s.length();x++){
            if(isPalindrome(s.substring(i,x+1))){
                temp.add(s.substring(i,x+1));
                solve(list,temp,s,x+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
};