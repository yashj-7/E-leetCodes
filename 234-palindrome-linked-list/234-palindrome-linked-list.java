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
    public boolean isPalindrome(ListNode head) {
        ListNode start = head;
        ListNode slow = head;
        ListNode fast  = head;
        if(head.next==null){
            return true;
        }
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println(slow.val);
        // System.out.println(slow.next.val);
        slow.next = reverse(slow.next);
        // ListNode temp  =head;
        // while(temp!=null){
        //     System.out.print(temp.val+" ");
        //     temp = temp.next;
        // }
        slow = slow.next;
        while(slow!=null){
            if(start.val!=slow.val){
                return false;
            }
            start = start.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode t1){
        if(t1.next==null){
            return t1;
        }
        ListNode newHead = reverse(t1.next);
        t1.next.next = t1;
        t1.next = null;
        return newHead;
    }
}