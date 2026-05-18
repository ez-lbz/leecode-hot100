package hot100.Solution45;

import hot100.Solution36.TreeNode;
import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (true) {
            TreeNode node = queue.poll();
            if (queue.peek() != null) {
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            } else {
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                res.add(node.val);
                queue.poll();
                if (queue.isEmpty()) break;
                queue.offer(null);
            }
        }
        return res;
    }
}