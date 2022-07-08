/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode node, int k) {
        if(node == null){
            return null;
        }
        int total = 0;
        ListNode n = node;
        while(n!=null){
            total++;
            n=n.next;
        }
        int x = total-total%k;
        n = node;
        //Node temp = null;
        while(n!=null && x>0){
            n=n.next;
            x--;
        }
        //temp = n;
        int count=0;
        ListNode curr = node;
        ListNode next = null;
        ListNode prev = null;
        while(curr!=null && count<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!=null){
            if(next==n){
                node.next = next;
            }else{
                node.next = reverseKGroup(next,k);    
            }
            
        }
        return prev;
    }
}