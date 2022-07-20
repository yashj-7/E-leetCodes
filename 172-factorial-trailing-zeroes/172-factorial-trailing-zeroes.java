class Solution {
    public int trailingZeroes(int n) {
        int c = 0;
        int prod=5;
        while(n/prod>0){
            c+=n/prod;
            prod = prod*5;
        }
        return c;
    }
}