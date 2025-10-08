/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // base case
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // traverse both lists
        while (a != b) {
            // move forward or switch head
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // either intersection node or null
        return a;
    }
}