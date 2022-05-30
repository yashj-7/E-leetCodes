// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String x)
    {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)=='+'){
                int z = s.pop();
                int y = s.pop();
                s.push(z+y);
            }else if(x.charAt(i)=='-'){
                int z = s.pop();
                int y = s.pop();
                s.push(y-z);
            }else if(x.charAt(i)=='*'){
                int z = s.pop();
                int y = s.pop();
                s.push(z*y);
            }else if(x.charAt(i)=='/'){
                int z = s.pop();
                int y = s.pop();
                s.push(y/z);
            }else{
                s.push(Character.getNumericValue(x.charAt(i)));
            }
        }
        return s.pop();
    }
}