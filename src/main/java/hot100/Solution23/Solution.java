package hot100.Solution23;

// 这个ez题我不太熟悉，多看两次吧

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if  (head == null || head.next == null) return head;
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;

    }
}