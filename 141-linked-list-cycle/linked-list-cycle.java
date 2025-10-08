/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) 
            return false;

        // Initialize two pointers
        ListNode slow = head;  // moves 1 step
        ListNode fast = head;  // moves 2 steps

        // Traverse until fast reaches end
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move slow by one
            fast = fast.next.next;     // move fast by two

            if (slow == fast)          // if both meet → cycle exists
                return true;
        }

        // if we exit loop → fast reached null → no cycle
        return false;
    }
}