class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String s = words[i];
            HashMap<Character,Character> map1 = new HashMap<>();
            HashMap<Character,Character> map2 = new HashMap<>();
            int j=0;
            for(j=0;j<s.length();j++){
                if(map1.containsKey(pattern.charAt(j))==false){
                    map1.put(pattern.charAt(j),s.charAt(j));
                }
                if(map2.containsKey(s.charAt(j))==false){
                    map2.put(s.charAt(j),pattern.charAt(j));
                }
                if(map1.get(pattern.charAt(j))!=s.charAt(j) || map2.get(s.charAt(j))!=pattern.charAt(j)){
                    break;
                }
            }
            if(j==s.length()){
                list.add(s);
            }
        }
        return list;
    }
}