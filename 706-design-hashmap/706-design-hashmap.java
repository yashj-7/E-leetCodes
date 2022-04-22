class MyHashMap {
    ArrayList<Integer> keyList ;
    ArrayList<Integer> valueList;
    public MyHashMap() {
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        int k = keyList.indexOf(key);
        if(k==-1){
            keyList.add(key);
        valueList.add(value);
        }else{
            valueList.set(k,value);
        }
        
    }
    
    public int get(int key) {
        int k = keyList.indexOf(key);
        if(k!=-1){
            return valueList.get(k);
        }else{
            return -1;   
        }
    }
    
    public void remove(int key) {
        int k = keyList.indexOf(key);
        if(k!=-1){
            keyList.remove(k);
            valueList.remove(k);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */