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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode t1 = new ListNode(-1);
        t1.next = head;
        ListNode ans = t1;
        ListNode t2 = head;
        while(t1!=null && t2!=null && t2.next!=null){
            if(t2.val==t2.next.val){
                int data = t2.val;
                while(t2!=null && t2.val==data){
                    t2=t2.next;
                }
//                 if(t2==null){
                    
//                 }
                t1.next=t2;
            }else{
                t1=t1.next;
                t2=t2.next;
            }
        }
        return ans.next;
    }
}