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
    public void reorderList(ListNode head) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode temp = head;
        int cnt = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        while(temp!=null){
            s1.push(temp);
            cnt++;
            temp = temp.next;   
        }
        // System.out.println(cnt);
        // System.out.println(s1);
        
        reverse(s2,head);
        //System.out.println(s2);
        int cn = cnt;
        //if(cnt%2==0){
            while(cn!=cnt/2){
                ListNode n1 = s1.pop();
                ListNode n2 = s2.pop();
               // System.out.println(n1.val+" "+n2.val);
                n2.next = n1;
                if(cn==cnt){
                    dummy = dummy.next.next;
                }else{
                    dummy.next = n2;
                    dummy = dummy.next.next;
                }
                cn--;
            }
            dummy.next=null;
        
    }
    public static void reverse(Stack<ListNode> s,ListNode head){
        if(head==null){
            return ;
        }
        reverse(s,head.next);
        s.push(head);
    }
}