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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        s.push(head);
        ListNode temp = head.next;
        while(temp!=null){
            if(s.peek().val>temp.val){
                s.push(temp);
            }else{
                while(s.isEmpty()==false && s.peek().val<temp.val){
                    s.pop();
                }
                s.push(temp);
            }
            temp=temp.next;
        }
        Stack<ListNode> st = new Stack<>();
        while(s.isEmpty()==false){
            st.push(s.pop());
        }
        if(st.isEmpty()==false){
            head = st.pop();    
        }
        temp = head;
        while(st.isEmpty()==false){
            temp.next = st.pop();
            temp=temp.next;
        }
        return head;
    }
}