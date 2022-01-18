class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0 ;
        int r =0;
        int count = 0;
        HashMap<Character,Integer> hm =new HashMap<Character,Integer>();
        while(r<s.length()){
            if(hm.containsKey(s.charAt(r))){
                l = Math.max(hm.get(s.charAt(r))+1,l);
            }
                hm.put(s.charAt(r),r);
                count = Math.max(count,r-l+1);
            r++;
        }
        return count;
    }
}

