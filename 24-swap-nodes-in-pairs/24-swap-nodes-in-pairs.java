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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        if(head==null || head.next==null){
            return head;
        }
        int c = 0;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        temp = head;
         while(temp!=null && temp.next!=null){
            int val = temp.val;
            temp.val = temp.next.val;
            temp.next.val = val;
            temp = temp.next.next;
        }
        return head;   
    }
}