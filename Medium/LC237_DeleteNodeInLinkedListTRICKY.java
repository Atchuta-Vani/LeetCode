
 //TRICKY, no access to head here, so cant have dummy and prev as in 203
 //since we can not access previous node. copy next node value to current node and skip next node. 
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
