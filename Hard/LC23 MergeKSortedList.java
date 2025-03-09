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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode current = result;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        if(lists == null || lists.length == 0){
            return null;
        }

        for(ListNode l:lists){
            while(l!=null){
                q.offer(l.val);
                l=l.next;
            }
        }

        while(!q.isEmpty()){
            int value = q.poll();
            ListNode node = new ListNode(value,null);
            current.next= node;
            current = current.next;
        }
        return result.next;
        
    }
}
