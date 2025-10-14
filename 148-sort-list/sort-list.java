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

    public ListNode sortList(ListNode head) {
        // Base case
        if (head == null || head.next == null)
            return head;

        // Step 1: Find the middle node
        ListNode mid = getMid(head);

        // Step 2: Split the list into two halves
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // Step 3: Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Step 4: Merge the two sorted halves
        return merge(left, right);
    }

    // Helper to find the middle node
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper to merge two sorted linked lists
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // Attach the remaining part
        if (list1 != null) temp.next = list1;
        else temp.next = list2;

        return dummy.next;
    }
}