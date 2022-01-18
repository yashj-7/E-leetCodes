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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode temp = head;
        int c = 1;
        ListNode t = head;
        int count = 0;
        while(t!=null){
            count++;
            t = t.next;
        }
        n = count-n+1;
        if(count==1 || n==1){
            return head.next;
        }
        while(temp!=null && temp.next!=null){
            prev = temp;
            temp =temp.next;
            c++;
            if(c==n){
                prev.next = temp.next;
            } 
              
        }
        return head;
    }
}