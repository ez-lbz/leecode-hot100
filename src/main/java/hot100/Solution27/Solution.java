package hot100.Solution27;

import hot100.Solution22.ListNode;

public class Solution {
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