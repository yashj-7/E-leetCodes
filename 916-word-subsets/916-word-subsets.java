class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<Character,Integer> hm1 = new HashMap<>();
        //String com = "";
        for(int i=0;i<words2.length;i++){
            String s = words2[i];
            // com += words2[i];
            HashMap<Character,Integer> hm = new HashMap<>();
            for(int j=0;j<s.length();j++){
                if(hm1.containsKey(s.charAt(j))==false){
                    hm1.put(s.charAt(j),1);
                    hm.put(s.charAt(j),1);
                }else{
                    if(hm.containsKey(s.charAt(j))){
                        hm.put(s.charAt(j),hm.get(s.charAt(j))+1);
                    }else{
                        hm.put(s.charAt(j),1);
                    }
                    if(hm.get(s.charAt(j))>hm1.get(s.charAt(j))){
                        hm1.put(s.charAt(j),hm.get(s.charAt(j)));
                    }
                }
            }
        }
        Object[] keys = hm1.keySet().toArray();
        System.out.println(hm1);
        List<String> list = new ArrayList<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i=0;i<words1.length;i++){
            String x = words1[i];
            for(int j=0;j<x.length();j++){
                if(hm2.containsKey(x.charAt(j))){
                    hm2.put(x.charAt(j),hm2.get(x.charAt(j))+1);
                }else{
                    hm2.put(x.charAt(j),1);
                }
            }
            //System.out.println(hm2);
            int flag = 0;
            // for(int j=0;j<com.length();j++){
            //     if(hm2.containsKey(com.charAt(j))==false){
            //         flag = false;
            //         break;
            //     }else{
            //        if(hm2.get(com.charAt(j))<hm1.get(com.charAt(j))){
            //            flag=false;
            //            break;
            //        }
            //     }
            // }
            // if(flag){
            //     list.add(x);
            // }
            
            // for(int j=0;j<keys.length;j++){
            //     System.out.println(hm1.get(keys[j]));
            //     if(hm2.get(keys[j].toString().charAt(0))>hm1.get(keys[j].toString().charAt(0))){
            //         flag = false;
            //         break;
            //     }
            // }
            int count = 0;
            for(int j=0;j<x.length();j++){
                if(hm1.containsKey(x.charAt(j))==true && hm2.containsKey(x.charAt(j))==true && hm1.get(x.charAt(j))<=hm2.get(x.charAt(j))){
                    flag++;
                    hm2.remove(x.charAt(j));
                }
            }
            if(flag==hm1.size()){
                list.add(x);
            }
            hm2.clear();
        }
        return list;
    }
}