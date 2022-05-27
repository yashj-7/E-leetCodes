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
    public ListNode removeElements(ListNode head, int val) {
        return solve(head,val);
    }
    public static ListNode solve(ListNode head,int val){
        if(head==null){
            return null;
        }
        head.next = solve(head.next,val);
        if(head.val == val){
            return head.next;
        }
        return head;
    }
}