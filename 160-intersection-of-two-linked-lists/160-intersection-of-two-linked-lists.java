/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = 0;
        int count2 = 0;
        ListNode t1 = headA;
        ListNode t2 = headB;
     
        while(t1!=null){
            count1++;
            t1 = t1.next;
        }
        while(t2!=null){
            count2++;
            t2 = t2.next;
        }
        t1 = headA;
        t2 = headB;
        if(count1<count2){
            while(count1!=count2){
                t2 = t2.next;
                count1++;
            }
        }else if(count2<count1){
            while(count2!=count1){
                t1 = t1.next;
                count2++;
            }
        }
        while(t1!=null && t2!=null){
            if(t1==t2){
                return t1;
            }else{
                t1 = t1.next;
                t2 = t2.next;
            }
        }
        return null;
    }
}