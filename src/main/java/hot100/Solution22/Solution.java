package hot100.Solution22;


import java.util.*;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> s = new HashSet<>();
        ListNode ln = headA;
        while (ln != null) {
            s.add(ln);
            ln = ln.next;
        }
        ln = headB;
        while (ln != null) {
            if (s.contains(ln)) {
                return ln;
            }
            ln = ln.next;
        }
        return null;

    }
}