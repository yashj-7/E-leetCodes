class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();  
        HashMap<String,Integer> hm = new HashMap<>();
        int i=1;
        int j=10;
        try{
           hm.put(s.substring(0,10),1); 
        }catch(Exception e){
            return list;
        }
        
        while(j<s.length()){
            if(hm.containsKey(s.substring(i,j+1))==true && hm.get(s.substring(i,j+1))<=1){
                list.add(s.substring(i,j+1));
                hm.put(s.substring(i,j+1),hm.get(s.substring(i,j+1))+1);
            }else if(hm.containsKey(s.substring(i,j+1))==false){
                hm.put(s.substring(i,j+1),1);
            }
            i++;j++;
        }
        return list;
    }
}