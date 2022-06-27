// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String A = read.readLine().trim();
            
            String ans = obj.chooseandswap(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    
    
    String chooseandswap(String A){
       // String[] alpha = {"a","b","c","d","e"."f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"}
        SortedSet<Character> hs = new TreeSet<>();
        for(int i=0;i<A.length();i++){
            if(hs.contains(A.charAt(i))==false){
                hs.add(A.charAt(i));    
            }
            
        }
        char[] ans = A.toCharArray();
        Character a1 = 'a';
        Character a2 = 'a';
        for(int i=0;i<A.length();i++){
            try{
                if(hs.first()>=A.charAt(i)){
                hs.remove(A.charAt(i));
            }else{
                a1 = A.charAt(i);
                a2 = hs.first();
                break;
            }
            }catch(NoSuchElementException nse){
                //System.out.println(hs);
            }
            
        }
        for(int i=0;i<ans.length;i++){
            char c = ans[i];
            if(c==a1){
                ans[i] = a2;
            }else if(c==a2){
                ans[i] = a1;
            }
        }
        String res = "";
        for(int i=0;i<ans.length;i++){
            res = res+Character.toString(ans[i]);
        }
        return res;
    }
    
}