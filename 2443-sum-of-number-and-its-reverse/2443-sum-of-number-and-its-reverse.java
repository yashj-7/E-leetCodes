class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if(num<10 && num%2==0){
            return true;
        }
       for(int i=1;i<num;i++){
           int x = reverse(i);
           if(x+i==num){
               return true;
           }
       } 
        return false;
    }
    public static int reverse(int num){
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        return Integer.parseInt(sb.reverse().toString());
    }
}