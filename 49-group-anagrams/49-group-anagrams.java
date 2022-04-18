class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<Character>,ArrayList<String>> hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            ArrayList<Character> temp = new ArrayList<>();
            for(int j=0;j<c.length;j++){
                temp.add(c[j]);
            }
            if(hm.containsKey(temp)){
                hm.get(temp).add(strs[i]);
            }else{
                ArrayList<String> t1 = new ArrayList<>();
                t1.add(strs[i]);
                hm.put(temp,t1);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        //System.out.print(hm);
        
        for(int i=0;i<strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            ArrayList<Character> temp = new ArrayList<>();
            for(int j=0;j<c.length;j++){
                temp.add(c[j]);
            }
            if(ans.contains(hm.get(temp))==false){
                ans.add(hm.get(temp));
            }
        }
        return ans;
    }
}