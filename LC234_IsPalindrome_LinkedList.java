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

 /**
 Step-by-step thinking:

Find the middle of the linked list using slow and fast pointers.

Reverse the second half of the list starting from the middle.

Compare the first half and reversed second half node by node.

If all corresponding nodes match → it’s a palindrome.
 
  */
  //234. Palindrome Linked List
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow, fast;
        slow = head;
        fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //this is second half
        ListNode rH = reverseList(slow);
       // System.out.println("ReverseHead is "+rH.val+"Head is "+head.val);
        
        //compare head and reverse head
        while( rH!=null){
            if(head.val != rH.val){
                return false;
            }
            head = head.next;
            rH = rH.next;
        }
            return true;
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode rH = null;        
        while(head!=null){
            ListNode temp = head.next;
            head.next = rH;
            rH = head;
            head = temp;
        }
    return rH;       
    }

}
