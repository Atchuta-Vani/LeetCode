//2. Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int carry = 0;
        int sum;
        int val;  
        ListNode node;      
        while(l1!=null && l2!=null){
            sum = l1.val + l2.val+carry;
            carry = sum/10;
            val = sum%10;
            node = new ListNode(val);
            current.next = node; 
            current = current.next;
            l1= l1.next;
            l2=l2.next;
        }

        if(l1 == null){
            if(carry == 0)
                current.next = l2;
            else{
                while(l2!=null){
                    sum = l2.val + carry;
                    carry = sum/10;
                    val = sum%10;
                    node = new ListNode(val);
                    current.next = node; 
                    current = current.next;
                    l2= l2.next;
                }
            }
        }
        if(l2 == null){
            if(carry == 0){
                current.next = l1;

            }else{
                while(l1!=null){
                    sum = l1.val + carry;
                    carry = sum/10;
                    val = sum%10;
                    node = new ListNode(val);
                    current.next = node; 
                    current = current.next;
                    l1= l1.next;
                }
                
            }
        }
        if(carry>0){
             node = new ListNode(carry);
             current.next = node; 
             current = current.next;
        }
    return result.next;    
    }
}
