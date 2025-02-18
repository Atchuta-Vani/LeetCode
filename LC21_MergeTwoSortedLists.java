// LC21 Merge Two Sorted List
//Have a mergeHead(Dummy head) and current, current keeps moving in merged list. return dummyHead.next at the end
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeHead = new ListNode();
        ListNode current = mergeHead;
        boolean isHeadNotAssigned = true, isSame = false;
        while(list1 != null && list2 != null){
            if(list1.val == list2.val){
                current.next = list1;
                list1=list1.next;
                current = current.next;
                current.next = list2;
                list2 = list2.next;
                current = current.next;

            }else if(list1.val < list2.val){
                    current.next = list1;
                    list1=list1.next;
                    current = current.next;
            }else{
                  current.next = list2;
                  list2=list2.next;
                  current = current.next;
            }
             
        }
        if(list1 == null && list2 != null){
            current.next = list2;
        }
        if(list2 == null && list1 != null){
            current.next = list1;
        }
        return mergeHead.next;
    }
}
