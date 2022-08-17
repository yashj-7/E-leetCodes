class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> hash = new HashSet<String>();
        for(int i =0;i<words.length;i++){
            String r = build(words[i]);
            hash.add(r);
        }
        return hash.size();
    }
    public static String build(String s){
       // List l1 = Arrays.asList(Alpha);
        String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};
        String t = "";
        for(int i=0;i<s.length();i++){
            t = t+MORSE[indexOf(s.charAt(i))];
        }
        return t;
    }
    public static int indexOf(char c){
         char[] Alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i=0;i<26;i++){
            if(Alpha[i] == c){
                return i;
            }
        }
        return 0;
    }
}