package hot100.Solution24;

// 我是傻逼，链表的ez题都想不出来

import hot100.Solution22.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode head0 = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return head0;
    }

    public boolean isPalindrome(ListNode head) {
        int num = 0;
        ListNode cur = head;
        while (cur != null) {
            num++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < num / 2; i++) {
            cur = cur.next;
        }
        ListNode tail = reverseList(cur);
        while (tail != head && tail != null) {
            if (tail.val != head.val) return false;
            tail = tail.next;
            head = head.next;
        }
        return true;



    }

}

