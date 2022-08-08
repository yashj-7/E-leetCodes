class Solution {
    public boolean isSubsequence(String s, String t) {
        return solve(s,t,0,0);
    }
    public static boolean solve(String s,String t,int i,int j){
        if(i>=s.length()){
            return true;
        }
        if(j>=t.length()){
            return false;
        }
        boolean t1 = false;
        if(s.charAt(i)==t.charAt(j)){
            t1 = solve(s,t,i+1,j+1);
        }else{
            t1 = solve(s,t,i,j+1);
        }
        return t1;
    }
}