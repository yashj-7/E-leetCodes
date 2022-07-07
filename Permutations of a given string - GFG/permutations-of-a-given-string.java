// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        List<String> list = new ArrayList<>();
        solve(S,"",list,0);
        Collections.sort(list);
        return list;
    }
    public static void solve(String sb, String ans,List<String> list,int i){
        if(sb.length()==0){
            if(list.contains(ans)){
                return;
            }
            list.add(ans);
            return;
        }
        for(int x=0;x<sb.length();x++){
            String temp = ans;
            ans = ans+Character.toString(sb.charAt(x));
            String temp2 = sb;
            sb = sb.substring(0,x)+sb.substring(x+1,sb.length());
            solve(sb,ans,list,i);
            ans = temp;
            sb = temp2;
        }
    }
}