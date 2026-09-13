class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode current = dummy;
        
        while (current.next != null) {
            if (current.next.val == val) {
                // Remove the node
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return dummy.next;
    }
}