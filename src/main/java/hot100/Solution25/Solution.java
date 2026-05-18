package hot100.Solution25;

import hot100.Solution22.ListNode;

import java.util.*;

// 没想到正经的O(1)方法，但是想到了点邪门的

//public class Solution {
//    public boolean hasCycle(ListNode head) {
//        for (int i = 0; i < 1000; i++) {
//            if (head == null) return false;
//            head = head.next;
//        }
//        return true;
//
//    }
//}


// 翻转链表法

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode h = head;
        ListNode pre = null;
        while (h != null) {
            ListNode next = h.next;
            h.next = pre;
            pre = h;
            h = next;
            if (h == head) return true;
        }
        return false;
    }
}