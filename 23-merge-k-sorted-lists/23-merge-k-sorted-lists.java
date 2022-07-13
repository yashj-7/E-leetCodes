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
    public ListNode mergeKLists(ListNode[] arr) {
        if(arr.length==0){
            return null;
        }
        ListNode x = arr[0];
        if(arr.length==1){
            return arr[0];
        }
        for(int i=1;i<arr.length;i++){
            ListNode y = arr[i];
            x = merge(x,y);
        }
        return x;
    }
    public static ListNode merge(ListNode x,ListNode y){
        ListNode node = new ListNode(-1);
        ListNode res = node;
        while(x!=null && y!=null){
            ListNode n = new ListNode(-1);
            if(x.val<=y.val){
                n.val = x.val;
                x=x.next;
            }else if(x.val>y.val){
                n.val = y.val;
                y=y.next;
            }
            node.next = n;
            node = node.next;
        }
        while(x!=null){
            ListNode n = new ListNode(-1);
            n.val = x.val;
            node.next = n;
            node = node.next;
            x = x.next;
        }
        while(y!=null){
            ListNode n = new ListNode(-1);
            n.val = y.val;
            node.next = n;
            node = node.next;
            y = y.next;
        }
        return res.next;
    }
}