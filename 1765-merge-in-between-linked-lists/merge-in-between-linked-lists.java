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
    public ListNode mergeInBetween(ListNode list1, int idx1, int idx2, ListNode list2) {
        int pos = 0;
        ListNode temp = list1;
        ListNode a = null, b=null;
        while(temp != null){
            if(pos == idx1-1) a = temp;
            if(pos == idx2+1){
                b = temp;
                break;
            }
            pos++;
            temp = temp.next;
        }
        a.next = list2;
        ListNode tail = list2;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = b;
        return list1;
    }
}