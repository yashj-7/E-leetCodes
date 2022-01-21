/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        if(head==null){
            return null;
        }
        while(temp!=null){
            Node n = new Node(temp.val);
            Node t = temp.next;
            temp.next = n;
            n.next = t;
            temp = t;
        }
        
        temp = head;
        while(temp!=null){
            if(temp.random!=null){
             temp.next.random = temp.random.next;   
            }else{
                temp.next.random = null;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node dummy = temp.next;
        Node res = dummy;
        Node front = temp.next.next;
        while(front!=null){
            dummy.next = front.next;
            temp.next = front;
            temp = front;
            front = front.next.next;
            dummy = dummy.next;
        }
        dummy.next = null;
        temp.next = null;
        return res;
    }
}