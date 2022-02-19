class Solution {
    public int strStr(String s, String pat) {
        if(s.length()==0 && pat.length()==0){
            return 0;
        }
        if(s.length()==0){
            return -1;
        }
        if(pat.length()==0){
            return 0;
        }
        int[] lps = new int[pat.length()];
		computeLpsArray(lps,pat);
		int i=0;
		int j=0;
		while(i<s.length()){
			if(j==pat.length()) {
			 return(i-j);
			}
			if(s.charAt(i)==pat.charAt(j)) {
				i++;
				j++;
			}else {
				if(j==0) {
					i++;
				}else {
					j=lps[j-1];
				}
			}
		}
        if(j==pat.length()){
            return(i-j);
        }
			return -1;
    }
    
    public static void computeLpsArray(int[] lps,String s) {
		lps[0] = 0;
		int len = 0;
		int i=1;
		while(i<s.length()) {
			if(s.charAt(i)==s.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}else {
				if(len!=0) {
					len = lps[len-1];
				}else {
					lps[i]= len;
					i++;
				}
			}
		}
	}
    
}