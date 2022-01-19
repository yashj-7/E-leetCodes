/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> ht = new HashSet<ListNode>();
        boolean bool = false;
        while(bool==false && head!=null){
            if(ht.contains(head)==true){
                bool = true;
                return bool;
            }
            ht.add(head);
            head = head.next;
        }
        return false;
    }
}