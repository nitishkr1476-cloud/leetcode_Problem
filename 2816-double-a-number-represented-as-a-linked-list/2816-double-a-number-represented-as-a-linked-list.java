class Solution {
    public ListNode doubleIt(ListNode head) {
        int carry = doubleNode(head);

        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }

        return head;
    }

    private int doubleNode(ListNode node) {
        if (node == null) {
            return 0;
        }

        int carry = doubleNode(node.next);

        int value = node.val * 2 + carry;

        node.val = value % 10;

        return value / 10;
    }
}