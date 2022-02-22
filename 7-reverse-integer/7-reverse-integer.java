class Solution {
    public int reverse(int x) {
        int i=0;
        String temp = String.valueOf(x);
        if(temp.charAt(0)=='-' || temp.charAt(0)=='+'){
            i=1;
        }
        StringBuilder sb = new StringBuilder(temp);
        int j = temp.length()-1;
        while(i<j){
            char ch = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,ch);
            i++;
            j--;
        }
        try{
           return Integer.parseInt(sb.toString()); 
        }catch(NumberFormatException nfe){
            return 0;
        }
    }
}