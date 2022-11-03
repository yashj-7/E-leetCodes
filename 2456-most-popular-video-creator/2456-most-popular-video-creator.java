class Solution {
    
    HashMap<String,Integer> hm;
    
    class Triplet{
        String name;
        String id;
        int views;
        Triplet(String name,String id,int views){
            this.name=name;
            this.id=id;
            this.views=views;
        }
    }
    
    class ManComparator implements Comparator<Triplet>{
        public int compare(Triplet t1,Triplet t2){
            if(hm.get(t1.name)>hm.get(t2.name)){
                return -1;
            }else if(hm.get(t1.name)==hm.get(t2.name)){
                if(t1.views>t2.views){
                    return -1;
                }else if(t1.views==t2.views){
                    if(t1.id.compareTo(t2.id)>0){
                        return 1;
                    }else{
                        return -1;
                    }
                }
                else{
                    return 1;
                }
            }else{
                return 1;
            }
        }
    }
    
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Triplet[] arr = new Triplet[creators.length];
        for(int i=0;i<creators.length;i++){
            arr[i]=new Triplet(creators[i],ids[i],views[i]);
        }
        
        hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i].name)){
                hm.put(arr[i].name,hm.get(arr[i].name)+arr[i].views);
            }else{
                hm.put(arr[i].name,arr[i].views);
            }
        }
        
        Arrays.sort(arr,new ManComparator());
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i].name+" "+arr[i].id+" "+arr[i].views);
        // }
        List<List<String>> list = new ArrayList<>();
        
        
        
        List<String> temp = new ArrayList<>();
        temp.add(arr[0].name);
        temp.add(arr[0].id);
        list.add(temp);
        int highest = hm.get(arr[0].name);
        String name = arr[0].name;
        HashSet<String> hs = new HashSet<>();
        hs.add(name);
        
        for(int i=1;i<arr.length;i++){
            if(hs.contains(arr[i].name)==false && hm.get(arr[i].name)==highest){
                List<String> tem = new ArrayList<>();
                tem.add(arr[i].name);
                tem.add(arr[i].id);
                name = arr[i].name;
                list.add(new ArrayList<>(tem));
                hs.add(name);
            }
        }
        return list;
    }
}