class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i = 0;
        int j = 0;
        int x = Math.min(strs[0].length(),strs[strs.length-1].length());
        String ans = "";
        if(strs.length==0 || strs[0].length()==0){
            return "";
        }
        if(strs.length<2){
            return strs[0];
        }
        System.out.print(x);
        while(i<x && j<x){
            if(strs[0].charAt(i)!=strs[strs.length-1].charAt(j)){
                break;
            }else{
                ans = ans+Character.toString(strs[0].charAt(i));
            }
            i++;
            j++;
        }
        return ans;
    }
}