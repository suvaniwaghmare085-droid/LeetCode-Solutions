class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Find the kth node
        ListNode kth = head;

        for (int i = 0; i < k; i++) {
            if (kth == null) {
                return head;
            }
            kth = kth.next;
        }

        // Save the node after the group
        ListNode nextGroup = kth;

        // Reverse the current group
        ListNode prev = null;
        ListNode curr = head;

        while (curr != nextGroup) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Connect the original head to the next group
        head.next = reverseKGroup(nextGroup, k);

        // prev is the new head of this group
        return prev;
    }
}
