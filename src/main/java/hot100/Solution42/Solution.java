package hot100.Solution42;

import hot100.Solution36.TreeNode;
import sun.reflect.generics.tree.Tree;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode head = new TreeNode(nums[(nums.length - 1) / 2]);
        dfs(head, nums, 0, nums.length - 1);
        return head;
    }

    public void dfs(TreeNode root, int[] nums, int left, int right) {
        if (right == left) {
            return;
        } else if (right - left == 1) {
            TreeNode node = new TreeNode(nums[right]);
            root.right = node;
            return;
        } else {
            TreeNode node0 = new TreeNode(nums[(left + (left + right) / 2 - 1) / 2]);
            root.left = node0;
            dfs(node0, nums, left, (left + right) / 2 - 1);

            TreeNode node1 = new TreeNode(nums[((left + right) / 2 + 1 + right) / 2]);
            root.right = node1;
            dfs(node1, nums, (left + right) / 2 + 1, right);
        }
    }
}