class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        // Check whether there are at least k nodes
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
        }

        // Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // head is now the last node of this group
        head.next = reverseKGroup(curr, k);

        // prev is the new head of this group
        return prev;
    }
}