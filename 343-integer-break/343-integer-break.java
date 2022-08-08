class Solution {
    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        return solve(n,1,0);
    }
    public static int solve(int n,int k,int sumSoFar){
        if(sumSoFar+k>n){
            return 0;
        }
        if(sumSoFar+k==n){
            return k;
        }
        int x = k*solve(n,k,sumSoFar+k);
        int y = solve(n,k+1,sumSoFar);
        return Math.max(x,y);
    }
}