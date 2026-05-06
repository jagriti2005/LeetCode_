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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if(l1 != null) current.next = l1;
        else current.next = l2;

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode result = lists[0];
        for(int i=1;i<lists.length;i++){
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }
}