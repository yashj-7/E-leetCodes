// { Driver Code Starts
//Initial Template for Java
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
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1;i<S.length();i++){
            if(S.charAt(i)=='('){
                s.push(i);
            }else{
                if(s.isEmpty()==false && S.charAt(s.peek())=='('){
                    s.pop();
                }else{
                    s.push(i);
                }
            }
        }
        // if(s.isEmpty()){
        //     return S.length();
        // }
        s.push(S.length());
        //System.out.println(s);
        int ans = 0;
        while(s.isEmpty()==false && s.size()>1){
            int x = s.pop();
            ans = Math.max(ans,x-s.peek()-1);
        }
        ans = Math.max(ans,s.pop()-0);
        return ans;
    }
};

//))()(()