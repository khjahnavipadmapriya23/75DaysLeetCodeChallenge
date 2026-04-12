class Solution {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        // Step 1: Find middle

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half

        ListNode prev = null;
        ListNode curr = slow.next;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        slow.next = null;

        // Step 3: Merge

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}