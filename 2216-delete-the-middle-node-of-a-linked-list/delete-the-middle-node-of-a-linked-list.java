class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Base case: 0 or 1 node
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;  // to keep track of node before slow

        // Move fast by 2 and slow by 1
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Now slow is at middle node, prev is just before it
        prev.next = slow.next;  // safely remove middle node

        return head;
    }
}
