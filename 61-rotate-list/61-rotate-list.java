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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        if(count==0){
            return null;
        }
        if(k<count){
            k = count-k;
        }else if(k==count){
            return head;
        }else if(k>count){
            k = k%count;
            k = count-k;
        }
        temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        int i=1;
        temp = head;
        while(i<k){
            temp = temp.next;
            i++;
        }
        ListNode res = temp.next;
        temp.next = null;
        return res;
    }
}