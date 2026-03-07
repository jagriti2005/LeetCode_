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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tempA = head;
        ListNode tempB = head.next;
        ListNode ans = tempB;
        while(tempA != null && tempB != null){
            ListNode temp = tempB.next;
            tempB.next = tempA;
            if(temp == null || temp.next == null){
                tempA.next = temp;
                break;
            }
            tempA.next = temp.next;
            tempA = temp;
            tempB = tempA.next;
        }
        return ans;
    }
}