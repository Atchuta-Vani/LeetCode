//Given the head of a singly linked list, reverse the list, and return the reversed list.

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
    public ListNode reverseList(ListNode head) {
        ListNode j, temp, rh = head;
        if(head == null || head.next == null){
            return head;
        }
        j = head.next;
        head.next = null;

        while(j!=null){
            temp = j.next;
            j.next=rh;
            rh = j;
            j= temp;
        }
        return rh;
        //1 2   3 4 5 
        //RH j  tmp
