import java.util.HashSet;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        // Store nums values in HashSet
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        // Remove nodes from the beginning
        while (head != null && set.contains(head.val)) {
            head = head.next;
        }
        
        // Remove nodes after head
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        
        return head;
    }
}