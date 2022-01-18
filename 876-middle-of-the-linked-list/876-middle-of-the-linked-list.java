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
    public ListNode middleNode(ListNode head) {
        int c = 1;
        int aim = 0;
        ListNode temp = new ListNode();
        temp = head;
        while(temp.next!=null){
            c++;
            temp = temp.next;
        }
        if(c%2==0){
            aim = c/2+1;
        }else{
            aim = (int)Math.ceil(c/2.0);
        }
        c=1;
        temp = head;
        while(temp!=null){
            if(c==aim){
                return temp;
            }else{
                temp = temp.next;
                c++;
            }
        }
        return head;
    }
}