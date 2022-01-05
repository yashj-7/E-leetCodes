class Solution {
    public void reverseString(char[] s) {
        s =reverse(s, s.length);
    }
    public static char[] reverse(char[] s, int length){
        if(length==0){
            return s;
        }
        char a = s[length-1];
        reverse(s,length-1);
        int i=length;
        s[s.length - length] = a;
        return s;
    }
}