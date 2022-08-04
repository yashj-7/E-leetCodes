class Solution {
    public int integerReplacement(int n) {
        if(n==Integer.MAX_VALUE){
            return 32;
        }
        return (int)solve(n);
    }
    public static int solve(int n){
        if(n<1){
            return (int)1e9;
        }
        if(n>Integer.MAX_VALUE){
            return (int)1e9;
        }
        if(n==1){
            return 0;
        }
        int x = (int)1e9;
        int y = (int)1e9;
        int z = (int)1e9;
        if(n%2==0){
            x = 1+solve(n/2);
        }else{
            if(n!=Integer.MAX_VALUE){
               y = 1+solve(n+1); 
            } 
            z = 1+solve(n-1);
        }
        return Math.min(x,Math.min(y,z));
    }
}