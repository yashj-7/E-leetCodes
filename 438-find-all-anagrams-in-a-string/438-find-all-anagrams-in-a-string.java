class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        HashMap<Character,Integer> hm2 = new HashMap<Character,Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<p.length();i++){
            if(hm.containsKey(p.charAt(i))){
                hm.put(p.charAt(i),hm.get(p.charAt(i))+1);
            }else{
                hm.put(p.charAt(i),1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))==false){
                hm.put(s.charAt(i),0);
            }
        }
        // for(int i=0;i<p.length();i++){
        //     if(hm2.containsKey(s.charAt(i))){
        //         hm2.put(s.charAt(i),hm.get(s.charAt(i))+1);
        //     }else{
        //         hm2.put(s.charAt(i),1);
        //     }
        // }
        // if(hm2.equals(hm1)){
        //     list.add(0);
        // }
//         hm.put(s.charAt(0),hm.get(s.charAt(0))-1);
//         for(int i=1;i<s.length();i++){
//             if(hm2.equals(hm1)){
//                 list.add(i);
//             }
            
//         }
        for(int i=0;i<s.length();i++){
            hm2.put(s.charAt(i),0);
        }
        int j=0;
        for(int i=0;i<s.length();i++){
            hm2.put(s.charAt(i),hm2.get(s.charAt(i))+1);
            if(i>=p.length()-1){
                // System.out.print(hm2);
                // System.out.println(hm);
                if(hm2.equals(hm)){
                    list.add(j);
                }
                    hm2.put(s.charAt(j),hm2.get(s.charAt(j))-1);
                
                j++;
            }  
        }
        return list;
    }
}