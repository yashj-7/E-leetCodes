class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hm1 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm1.containsKey(s.charAt(i))){
                hm1.put(s.charAt(i),hm1.get(s.charAt(i))+1);
            }else{
                hm1.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(hm1.containsKey(t.charAt(i))==false){
                return false;
            }else{
                hm1.put(t.charAt(i),hm1.get(t.charAt(i))-1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(hm1.get(s.charAt(i))!=0){
                return false;
            }
        }
        System.out.print(hm1);
        return true;
    }
}