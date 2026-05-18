package hot100.Solution41;

import hot100.Solution36.TreeNode;
import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.offer(root);
        queue.offer(null);
        List<Integer> tmp = new ArrayList<>();
        while (true) {
            TreeNode node = queue.poll();
            if (node != null) {
                tmp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            } else {
                res.add(tmp);
                if (queue.isEmpty()) break;
                tmp = new ArrayList<>();
                queue.offer(null);
            }
        }
        return res;
    }
}