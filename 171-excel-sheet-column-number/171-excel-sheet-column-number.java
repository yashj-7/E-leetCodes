class Solution {
    public int titleToNumber(String columnTitle) {
        int p = columnTitle.length()-1;
        int ans = 0;
        for(int i=0;i<columnTitle.length();i++){
            int pos = (((int)columnTitle.charAt(i))%65)+1;
            ans = ans+(int)(pos*Math.pow(26,p));
            p--;
        }
        return ans;
    }
}