class Solution {
    public String countAndSay(int n) {
        String ans="";
        return solve(n,ans);
    }
    public String solve(int n,String ans){
        if(n==1){
            ans = "1";
            return ans;
        }
        ans = solve(n-1,ans);
        int i=0;
        int j=0;
        String res = "";
        while(i<ans.length() && j<ans.length()){
            if(ans.charAt(i)==ans.charAt(j)){
                j++;
            }else{
                res = res+String.valueOf(j-i)+ans.charAt(i);
                i=j;
            }
        }
        if(i<ans.length() && j==ans.length()){
            res = res+String.valueOf(j-i)+ans.charAt(i);
        }
        return res;
    }
}