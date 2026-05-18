package hot100.Solution33;

// 乐死了，他这hot100根本没有普通的排序题，直接让我来链表排序

// 如果有二刷环节一定要自己独立写一遍

import hot100.Solution22.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {

        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null || head.next == null) return head;
        if (head.next == tail || head == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) fast = fast.next;
        }

        ListNode n2 = sortList(slow, tail);
        ListNode n1 = sortList(head, slow);
        ListNode result = mergeTwoLists(n1, n2);
        return result;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        else if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        }
        else {
            head = list2;
            list2 = list2.next;
        }

        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }

        while (list1 != null) {
            cur.next = list1;
            cur = cur.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        }
        return head;



    }
}