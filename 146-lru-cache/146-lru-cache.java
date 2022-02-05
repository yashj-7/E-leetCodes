

class LRUCache {
 
    class Node{
    public Node next;
    public Node prev;
    int val;
    int key;
    Node(int key,int val){
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}
    
    HashMap<Integer,Node> hm;
    
    int capacity;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head=new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        hm = new HashMap();
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            Node t2 = head.next;
            head.next = temp;
            temp.next = t2;
            t2.prev = temp;
            temp.prev = head;
            return temp.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        
        if(hm.containsKey(key)==false){
            Node t = new Node(key,value);
            Node temp = head.next;
            head.next = t;
            t.next = temp;
            t.prev = head;
            temp.prev = t;
            hm.put(key,t);
        }else{
            Node temp = hm.get(key);
            temp.val = value;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            Node t2 = head.next;
            head.next = temp;
            temp.next = t2;
            t2.prev = temp;
            temp.prev = head;
        }
       
        if(hm.size()>capacity){
            Node temp1 = tail.prev;
            System.out.print(temp1.val);
            int k = temp1.key;
            temp1.prev.next = temp1.next;
            temp1.next.prev = temp1.prev;
            hm.remove(k);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */