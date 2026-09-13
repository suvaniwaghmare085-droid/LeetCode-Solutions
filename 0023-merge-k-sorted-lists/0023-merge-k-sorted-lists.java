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

    public ListNode mergeKLists(ListNode[] lists) {

        // If there are no lists
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Start with the first list
        ListNode result = lists[0];

        // Merge each remaining list with result
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }

    // Function to merge two sorted linked lists
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // Dummy node makes handling the first node easier
        ListNode dummy = new ListNode(0);

        // temp will build our answer
        ListNode temp = dummy;

        // Compare nodes from both lists
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } 
            else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        // Attach whatever is remaining
        if (l1 != null) {
            temp.next = l1;
        } 
        else {
            temp.next = l2;
        }

        // dummy itself is not part of answer
        return dummy.next;
    }
}
