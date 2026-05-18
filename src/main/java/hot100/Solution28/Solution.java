package hot100.Solution28;

import hot100.Solution22.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head;
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else {
            flag = (l1.val + l2.val) / 10;
            head = new ListNode((l1.val + l2.val) % 10);
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode cur = head;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + flag;
            flag = sum / 10;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        while (l1 != null) {
            int sum = l1.val + flag;
            flag = sum / 10;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null) {
            int sum = l2.val + flag;
            flag = sum / 10;
            cur.next = new ListNode(sum % 10);
            l2 = l2.next;
            cur = cur.next;
        }

        if (flag == 1) {
            cur.next = new ListNode(1);

        }
        return head;
    }
}