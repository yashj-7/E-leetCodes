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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int cnt=0;
        while(temp!=null){
            temp = temp.next;
            cnt++;
        }
        int y = cnt-k+1;
        temp = head;
        ListNode temp2 = head;
        int i=1;
        while(i!=k){
            temp = temp.next;
            i++;
        }
        int j=1;
        while(j!=y){
            temp2 = temp2.next;
            j++;
        }
        int v = temp.val;
        temp.val = temp2.val;
        temp2.val = v;
        return head;
    }
}