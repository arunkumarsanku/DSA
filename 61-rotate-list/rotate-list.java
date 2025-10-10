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

    // \U0001f538 Helper: Find the Nth node in the linked list
    private ListNode findNthNode(ListNode temp, int n) {
        int count = 1;
        while (temp != null) {
            if (count == n) return temp;  // Found the nth node
            count++;
            temp = temp.next;
        }
        return temp;
    }

    // \U0001f539 Main Function: Rotate the list by k nodes
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        // Step 1: Find tail and length
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Step 2: Handle case where k is multiple of length
        if (k % len == 0) return head;

        // Step 3: Make it circular
        tail.next = head;

        // Step 4: Find new last node (len - k % len)
        k = k % len;
        ListNode newLastNode = findNthNode(head, len - k);

        // Step 5: New head = next of newLastNode
        head = newLastNode.next;
        newLastNode.next = null;  // Break the circular connection

        return head;
    }
}