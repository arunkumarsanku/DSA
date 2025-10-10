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

    // \U0001f538 Helper: Get Kth node from the current position
    private ListNode getKthNode(ListNode temp, int k) {
        k = k - 1; // move k-1 steps ahead
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp; // returns kth node or null if not enough nodes
    }

    // \U0001f538 Helper: Reverse a given linked list segment
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;   // store next node
            curr.next = prev;   // reverse link
            prev = curr;        // move prev forward
            curr = next;        // move curr forward
        }
        return prev; // new head after reversal
    }

    // \U0001f539 Main Function: Reverse nodes in groups of k
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null; // last node of previous reversed group

        while (temp != null) {
            // Step 1: Find kth node from temp
            ListNode kThNode = getKthNode(temp, k);

            // Step 2: If fewer than k nodes remain → stop
            if (kThNode == null) {
                if (prevLast != null)
                    prevLast.next = temp; // connect leftover nodes
                break;
            }

            // Step 3: Temporarily disconnect after kth node
            ListNode nextNode = kThNode.next;
            kThNode.next = null;

            // Step 4: Reverse current k nodes
            reverseLinkedList(temp);

            // Step 5: Connect with previous part or update head
            if (temp == head) {
                head = kThNode; // first group becomes new head
            } else {
                prevLast.next = kThNode;
            }

            // Step 6: Move prevLast and temp to next group
            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }
}