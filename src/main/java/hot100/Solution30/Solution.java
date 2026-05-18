package hot100.Solution30;

import hot100.Solution22.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        while (true) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head;
            head = head.next;
            if (temp.next.next != null && temp.next.next.next != null) {
                temp.next.next = temp.next.next.next;
            } else {
                break;
            }
        }

        return newHead;

    }
}