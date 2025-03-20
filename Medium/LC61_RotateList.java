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
//61 Rorate List
 /**
 Approach: 
 if head = null or head.next = null or k is zero, return head
 use tail pointer,find length of linkedList = n
 if k is greater than length, assign k = n%k, avoids multiple times reversing. 
if k = 0 return head;
else have two pointers starting at head and move n-k times, one assigning to prev and other to curr.   
delink between these two pointers by assigning first.next to null. 
assign tail.next to head.
return curr, which will be new head after rotation. 
  */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        ListNode first,second,tail;
        int n = 0;//variable to hold length of LinkedList.
        first =  head;
        second = head;
        tail = head;
        
        while(tail.next!= null){
            tail = tail.next;
            n++;
        }
        n++; //count for the last node
        
        if(k>=n)
            k = k%n;
        if(k==0)
            return head;

        int count = n-k;
        //System.out.println("count is "+count);
        while(count>0){
            first = second;
            second = second.next;
            count--;
        }
        
        tail.next = head;
        first.next = null;
        
        return second;
    }
}
