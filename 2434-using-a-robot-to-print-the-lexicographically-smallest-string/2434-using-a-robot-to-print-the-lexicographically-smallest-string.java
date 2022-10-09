class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            st.push(s.charAt(i));
            freq[s.charAt(i)-'a']--;
            while(st.isEmpty()==false){
                char c = st.peek();
                if(checkSmaller(c,freq)) break;
                sb.append(st.pop());
            }
        }
        return sb.toString();
    }
    public static boolean checkSmaller(char c,int[] freq){
        int index = (int)(c-'a');
        for(int i=0;i<index;i++){
            if(freq[i]>0){
                return true;
            }
        }
        return false;
    }
}