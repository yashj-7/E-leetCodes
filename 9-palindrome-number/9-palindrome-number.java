class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        return palindrome(s);
    }
    public boolean palindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}