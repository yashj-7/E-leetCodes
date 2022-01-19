
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode start = l1;
        int carry = 0;
        while(t1!=null && t2!=null){
            if(t1.val+t2.val+carry < 10){
                //System.out.println(carry);
                l1.val = carry+t1.val+t2.val;
                carry = 0;
            }else if(t1.val+t2.val +carry>9){
                int x = (t1.val+t2.val+carry);
                l1.val = (x)%10;
                carry = (x)/10;
            }
            t1 = t1.next;
            t2 = t2.next;
            if(l1.next==null){
                break;
            }else{
                l1 = l1.next;
            }
        }
        if(t2==null && t1!=null){
                while(t1!=null){
                    int y = t1.val+carry;
                   l1.val = (t1.val+carry)%10;
                    carry = y/10;
                    t1 = t1.next;
                    if(l1.next==null){
                        break;
                    }else{
                        l1 = l1.next;
                    }
                }
              
            }
        if(t1==null && t2!=null){
            l1.next = t2;
            l1=l1.next;
                while(t2!=null){
                    int y = t2.val+carry;
                   l1.val = (t2.val+carry)%10;
                    carry = y/10;
                    t2 = t2.next;
                    if(l1.next==null){
                        break;
                    }else{
                        l1 = l1.next;
                    }
                }
              
            }
            if(carry>0){
                ListNode temp  =new ListNode(carry,null);
                l1.next = temp;
                  carry = -1;
            }
        return start;
    }
}