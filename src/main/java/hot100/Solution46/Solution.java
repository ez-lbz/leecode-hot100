package hot100.Solution46;

import hot100.Solution36.TreeNode;
import java.util.*;

public class Solution {
    public void flatten(TreeNode root) {
        TreeNode tmp = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) return;
        if (root.right != null) stack.push(root.right);
        if (root.left != null) stack.push(root.left);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            tmp.right = node;
            tmp.left = null;
            tmp = node;
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

    }
}