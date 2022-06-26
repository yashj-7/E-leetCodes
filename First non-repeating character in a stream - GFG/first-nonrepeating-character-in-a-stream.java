// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        Queue<Character> q = new LinkedList<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        q.offer(A.charAt(0));
        hm.put(A.charAt(0),1);
        String ans = Character.toString(A.charAt(0));
        for(int i=1;i<A.length();i++){
            
           
                
            if(hm.containsKey(A.charAt(i))){
                hm.put(A.charAt(i),hm.get(A.charAt(i))+1);
                while(q.isEmpty()==false && hm.get(q.peek())>1){
                    q.poll();
            } 
            }else{
                hm.put(A.charAt(i),1);
                q.offer(A.charAt(i));
            }
            if(q.isEmpty()){
                ans = ans+"#";
            }else{
                ans = ans+Character.toString(q.peek());
            }
        }
        return ans;
    }
}