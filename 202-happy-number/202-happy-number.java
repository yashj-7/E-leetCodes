class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while(true){
            n=sumDigit(n);
            if(n==1){
                return true;
            }
            if(hs.contains(n)){
                return false;
            }else{
                hs.add(n);
            }
        }
    }
    public static int sumDigit(int n){
        int sum = 0;
        while(n!=0){
            int temp = n%10;
            sum = sum+temp*temp;
            n=n/10;
        }
        return sum;
    }
}