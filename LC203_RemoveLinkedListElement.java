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
Use a dummy node that points to the head. This helps to handle edge cases where the head itself needs to be removed.
Use two pointers:
prev to track the previous node
curr to traverse the list
If curr.val == val, remove curr by updating prev.next.
Otherwise, move both pointers forward.
*/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        if(head == null){
            return head;
        }
        ListNode current = head;
        dummy.next = head;
        ListNode prev = dummy;
        while(current != null){
            if(current.val == val){
                prev.next = current.next;
            }else{
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }
}
