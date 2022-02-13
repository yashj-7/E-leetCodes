class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        String ans = "";
        
        for(int j=words.length-1;j>=0;j--){
                if(j!=0){
                    ans = ans+words[j]+" ";
                }else{
                    ans = ans+words[j];
                }
        }
        return ans;
    }
}