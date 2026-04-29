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
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy; // last node before duplicates
        
        while (head != null) {
            // Check if it's the start of duplicates
            if (head.next != null && head.val == head.next.val) {
                
                // Skip all nodes with same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                
                // Remove duplicates
                prev.next = head.next;
                
            } else {
                // No duplicate → move prev forward
                prev = prev.next;
            }
            
            // Move head forward
            head = head.next;
        }
        
        return dummy.next;
    }
}